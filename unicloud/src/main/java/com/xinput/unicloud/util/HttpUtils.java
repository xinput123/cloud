package com.xinput.unicloud.util;

import com.xinput.cloud.util.JsonUtils;
import com.xinput.unicloud.model.reqeust.UniRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * 基于HttpClient实现的Http请求工具
 */
public class HttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private static volatile CloseableHttpClient instance;

    /**
     * 连接池
     */
    private static PoolingHttpClientConnectionManager CONN_MANAGER;

    private static RequestConfig REQUEST_CONFIG;

    /**
     * 监控连接间隔
     */
    private static final long RELEASE_CONNECTION_WAIT_TIME = 5000;

    private static LaxRedirectStrategy redirectStrategy = null;

    private static HttpRequestRetryHandler myRetryHandler = null;

    private static SSLConnectionSocketFactory sslConnectionSocketFactory = null;

    static {
        initHttpClient();
        // 启动清理连接池链接线程
        Thread thread = new IdleConnectionMonitorThread(CONN_MANAGER);
        thread.setName("bleach_idle_thread");
        thread.setDaemon(true);
        thread.start();
    }

    public static void initHttpClient() {
        REQUEST_CONFIG = RequestConfig.custom()
                .setConnectTimeout(10000)
                .setSocketTimeout(10000)
                .setConnectionRequestTimeout(10000)
                // 忽略cookie,如果不需要登陆最好去掉,否则修改策略保存cookie即可
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                //设置代理ip,不设置就用本机
                // .setProxy(ip)
                .build();

        // 重定向策略初始化
        redirectStrategy = new LaxRedirectStrategy();

        // 请求重试机制，默认重试3次
        myRetryHandler = (exception, executionCount, context) -> {
            if (executionCount >= 3) {
                return false;
            }
            if (exception instanceof InterruptedIOException) {
                return false;
            }
            if (exception instanceof UnknownHostException) {
                return false;
            }
            if (exception instanceof ConnectTimeoutException) {
                return false;
            }
            if (exception instanceof SSLException) {
                // SSL handshake exception
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
            if (idempotent) {
                // Retry if the request is considered idempotent
                return true;
            }
            return false;
        };

        try {
            SSLContextBuilder builder = new SSLContextBuilder();
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(), NoopHostnameVerifier.INSTANCE);
        } catch (Exception e) {
            logger.error("初始化httpclient连接池失败.", e);
        }

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new PlainConnectionSocketFactory())
                .register("https", sslConnectionSocketFactory)
                .build();
        // 创建httpclient连接池
        CONN_MANAGER = new PoolingHttpClientConnectionManager(registry);
        // 设置连接池最大数量,这个参数表示所有连接最大数。
        CONN_MANAGER.setMaxTotal(200);
        // 设置单个路由最大连接数量，表示单个域名的最大连接数，
        // 例如:www.baidu.com.www.google.com表示不同的域名,则连接统一域名下的资源的最大连接数就是该参数,总和是上面的参数。
        CONN_MANAGER.setDefaultMaxPerRoute(100);
    }

    public static CloseableHttpClient getInstance() {
        if (null == instance) {
            synchronized (CloseableHttpClient.class) {
                if (null == instance) {
                    instance = HttpClients.custom()
                            .setSSLSocketFactory(sslConnectionSocketFactory)
                            .setConnectionManager(CONN_MANAGER)
                            .setDefaultRequestConfig(REQUEST_CONFIG)
                            .setRedirectStrategy(redirectStrategy)
                            .setRetryHandler(myRetryHandler)
                            .build();
                }
            }
        }
        return instance;
    }

    /**
     * get请求
     *
     * @param url 请求的url地址
     * @return
     */
    public static String get(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        setCommonHeaders(httpGet);

        return execute(httpGet);
    }

    public static String post(String url, UniRequest uniRequest) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        setCommonHeaders(httpPost);
        System.out.println(JsonUtils.toJsonString(uniRequest));
        httpPost.setEntity(new StringEntity(JsonUtils.toJsonString(uniRequest), StandardCharsets.UTF_8));

        return execute(httpPost);
    }

    private static String execute(HttpUriRequest request) throws Exception {
        String content;
        HttpEntity entity = null;
        try {
            HttpResponse response = getInstance().execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("REQUEST URI:[{}], STATUS CODE : [{}]. ", request.getURI(), statusCode);
            // only for record log
            if (HttpStatus.SC_OK == statusCode) {
                logger.info("REQUEST URI:[{}] SUCCESS. ", request.getURI());
            } else {
                logger.error("REQUEST URI:[{}] ERROR. ERROR CODE : [{}].", request.getURI(), statusCode);
            }
            entity = response.getEntity();
            content = EntityUtils.toString(entity, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("NETWORK ERROR. URL : [{}].", request.getURI(), e);
            throw new Exception("NETWORK ERROR. URL: " + request.getURI(), e);
        } finally {
            // 确保释放连接
            EntityUtils.consume(entity);
        }

        System.out.println("响应值：\n " + content);
        return content;
    }

    private static void setCommonHeaders(AbstractHttpMessage request) {
        request.addHeader("Content-type", "application/json;charset=utf-8");
        request.setHeader("Accept", "application/json");
    }
}