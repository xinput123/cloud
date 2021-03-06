package com.xinput.unicloud.util;

import com.xinput.cloud.util.StringUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 11:41
 */
public class SignatureUtils {

    private static final Logger logger = LoggerFactory.getLogger(SignatureUtils.class);

    private static final String ALGORITHM = "HmacSHA1";

    private static final String ENCODING = "UTF-8";

    /**
     * 拼接 reqeust 请求参数
     *
     * @param parameters
     * @return enocde(key)=encode(value)
     */
    public static List<String> paramsToQuery(Map<String, Object> parameters) {
        // 将请求参数中的key value 进行 encode
        return parameters
                .keySet()
                .stream()
                .map(key -> encode(key) + "=" + encode(parameters.getOrDefault(key, StringUtils.EMPTY)))
                .collect(Collectors.toList());
    }

    /**
     * 对参数进行编码
     */
    public static String encode(Object s) {
        try {
            return s != null ? URLEncoder.encode((String) s, "UTF-8").replace("+", "%20")
                    .replace("*", "%2A").replace("%7E", "~") : null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String hmacSHA1Encrypt(String encryptText, String encryptKey) throws NoSuchAlgorithmException, InvalidKeyException {

        //根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(encryptKey.getBytes(), ALGORITHM);

        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(ALGORITHM);

        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);

        //完成 Mac 操作
        byte[] rawHmac = mac.doFinal(encryptText.getBytes());

        return new String(Base64.encodeBase64(rawHmac));
    }
}
