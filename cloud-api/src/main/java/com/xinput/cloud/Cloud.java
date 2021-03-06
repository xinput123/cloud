package com.xinput.cloud;

import com.google.common.collect.Lists;
import com.xinput.cloud.api.CloudApi;
import com.xinput.cloud.domain.CloudConfig;
import com.xinput.cloud.domain.req.DeleteEcsReq;
import com.xinput.cloud.domain.req.DescribeEcsReq;
import com.xinput.cloud.domain.req.DetailEcsReq;
import com.xinput.cloud.domain.req.RunEcsReq;
import com.xinput.cloud.domain.req.StartEcsReq;
import com.xinput.cloud.domain.req.StopEcsReq;
import com.xinput.cloud.domain.resp.DeleteEcsResp;
import com.xinput.cloud.domain.resp.DescribeEcsResp;
import com.xinput.cloud.domain.resp.DetailEcsResp;
import com.xinput.cloud.domain.resp.RunEcsResp;
import com.xinput.cloud.domain.resp.StartEcsResp;
import com.xinput.cloud.domain.resp.StopEcsResp;
import com.xinput.cloud.exception.ParamException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-18 18:20
 */
public class Cloud {

    private static ServiceLoader<CloudApi> printerLoader;

    private static CloudApi cloudApi;

    /**
     * 初始化云服务配置
     *
     * @param info
     * @throws Exception
     */
    public static void initCloud(CloudConfig info) throws ParamException {
        List<CloudApi> cloudApis = Lists.newArrayList();
        printerLoader = ServiceLoader.load(CloudApi.class);
        Iterator<CloudApi> cloudApiIterator = printerLoader.iterator();
        while (cloudApiIterator.hasNext()) {
            cloudApis.add(cloudApiIterator.next());
        }

        if (CollectionUtils.isEmpty(cloudApis)) {
            throw new ParamException("Please choose the way.");
        }

        if (cloudApis.size() != 1) {
            throw new ParamException("Too many ways to achieve.");
        }
        cloudApi = cloudApis.get(0);

        cloudApi.initCloud(info);
    }

    public static DescribeEcsResp describeEcs(DescribeEcsReq describeEcsReq) throws Exception {
        return cloudApi.describeEcs(describeEcsReq);
    }

    /**
     * 查询云主机实例详情
     *
     * @param detailEcsReq
     * @return
     * @throws Exception
     */
    public static DetailEcsResp detailEcs(DetailEcsReq detailEcsReq) throws Exception {
        return cloudApi.detailEcs(detailEcsReq);
    }

    /**
     * 创建云主机
     *
     * @param runEcsReq
     * @return
     * @throws Exception
     */
    public static RunEcsResp runEcs(RunEcsReq runEcsReq) throws Exception {
        return cloudApi.runEcs(runEcsReq);
    }

    /**
     * 开启云主机
     *
     * @param startEcsReq
     * @return
     * @throws Exception
     */
    public static StartEcsResp startEcs(StartEcsReq startEcsReq) throws Exception {
        return cloudApi.startEcs(startEcsReq);
    }

    /**
     * 关闭云主机
     *
     * @param stopEcsReq
     * @return
     * @throws Exception
     */
    public static StopEcsResp stopEcs(StopEcsReq stopEcsReq) throws Exception {
        return cloudApi.stopEcs(stopEcsReq);
    }

    public static DeleteEcsResp deleteEcs(DeleteEcsReq deleteEcsReq) throws Exception {
        return cloudApi.deleteEcs(deleteEcsReq);
    }
}
