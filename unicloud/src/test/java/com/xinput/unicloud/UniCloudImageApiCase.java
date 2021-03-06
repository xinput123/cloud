package com.xinput.unicloud;

import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.unicloud.model.reqeust.image.UniCloudCreateEcsSysSnapshotReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudCreateImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudDeleteImageReq;
import com.xinput.unicloud.model.reqeust.image.UniCloudDescribeImageReq;
import com.xinput.unicloud.model.response.image.UniCloudCreateEcsSysSnapshotResp;
import com.xinput.unicloud.model.response.image.UniCloudCreateImageResp;
import com.xinput.unicloud.model.response.image.UniCloudDeleteImageResp;
import com.xinput.unicloud.model.response.image.UniCloudDescribeImageResp;
import com.xinput.unicloud.util.UniCloudFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * 镜像测试用例
 */
public class UniCloudImageApiCase {

    @Before
    public void init() throws ParamException {
        String ak = "xxx";
        String sk = "xxx";
        UniCloudFactory.init(ak, sk);
    }

    /**
     * 私有镜像列表
     */
    @Test
    public void describeImages() throws Exception {
        UniCloudDescribeImageReq req = new UniCloudDescribeImageReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());

        UniCloudDescribeImageResp resp = UniCloudFactory.Image.describe(req);
        System.out.println("---私有镜像列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 生成私有镜像
     */
    @Test
    public void createImage() throws Exception {
        String instanceId = "ecs-kd9mjhb97flb";
        UniCloudCreateImageReq req = new UniCloudCreateImageReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId(instanceId);
        req.setImageName("xinut-image");

        UniCloudCreateImageResp resp = UniCloudFactory.Image.create(req);
        System.out.println("---生成私有镜像---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 释放私有镜像
     */
    @Test
    public void deleteImage() throws Exception {
        UniCloudDeleteImageReq req = new UniCloudDeleteImageReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setImageId("img-keat9rdtlpcs");

        UniCloudDeleteImageResp resp = UniCloudFactory.Image.delete(req);
        System.out.println("---释放私有镜像---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 创建系统盘快照
     */
    @Test
    public void createSnapshot() throws Exception {
        UniCloudCreateEcsSysSnapshotReq req = new UniCloudCreateEcsSysSnapshotReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-kd9mjhb97flb");
        req.setName("xinput");

        UniCloudCreateEcsSysSnapshotResp resp = UniCloudFactory.Image.createSnapshot(req);
        System.out.println("---创建系统盘快照---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }
}
