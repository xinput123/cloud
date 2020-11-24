package com.xinput.unicloud;

import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDeleteEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDescribeEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDetailEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudRebootEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudResetEcsPasswordReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudRunEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStartEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStopEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudUpdateEcsNameReq;
import com.xinput.unicloud.model.response.ecs.UniCloudDeleteEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDesctibeEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDetailEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudRebootEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudResetEcsPasswordResp;
import com.xinput.unicloud.model.response.ecs.UniCloudRunEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStartEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStopEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudUpdateEcsNameResp;
import com.xinput.unicloud.util.UniCloudFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * 云主机api demo
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-23 23:40
 */
public class UniCloudEcsApiCase {

    @Before
    public void init() throws ParamException {
        String accessKeyId = "xxx";
        String sk = "xxx";
        UniCloudFactory.init(accessKeyId, sk);
    }

    /**
     * 查询云主机实例列表
     */
    @Test
    public void describeEcs() throws Exception {
        UniCloudDescribeEcsReq req = new UniCloudDescribeEcsReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());

        UniCloudDesctibeEcsResp resp = UniCloudFactory.Ecs.describe(req);
        System.out.println("---查询云主机实例列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 查询云主机详情
     */
    @Test
    public void detailEcs() throws Exception {
        UniCloudDetailEcsReq req = new UniCloudDetailEcsReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-kec2yg1gkmvs");

        UniCloudDetailEcsResp resp = UniCloudFactory.Ecs.detail(req);
        System.out.println("---查询云主机详情---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 创建主机
     */
    @Test
    public void createEcs() throws Exception {
        UniCloudRunEcsReq req = new UniCloudRunEcsReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setAzoneId("HB1-BJMY2");
        req.setPayType(CloudConsts.PayTypeEnum.UNICLOUD_CHARGING_HOURS.getPayType());
        req.setVmSpecificationCode(CloudConsts.VmSpecificationCode.UNICLOUD_C1_MEDIUM_2.getCode());
        req.setSysDiskSpecificationCode("ebs.hybrid.hdd");
        req.setSysDiskSize(40);

        req.setImageId("img-kdrbc1quczhw");
        req.setImageSpecificationClassCode("ecs.image.private");

        req.setVpcId("vpc-eyxzmew8kagpb");

        req.setPassword("yuan1234");
        req.setInstanceName("xinput");
        req.setHostName("xinput-host");
        req.setDescription("这是一台测试机，通过接口开启");
        req.setBaseQuantity(1);
        req.setInitialShell("echo 123456-xinput");

        req.setSecurityGroupId("sg-j3xtbqhydigpb");
        req.setMasterEniSubNetId("8bd69b53fcf349058bb01c2efb4d8593");

        UniCloudRunEcsResp resp = UniCloudFactory.Ecs.create(req);
        System.out.println("---创建主机---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 云主机开机
     */
    @Test
    public void start() throws Exception {
        UniCloudStartEcsReq req = new UniCloudStartEcsReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-kd9mjhb97flb");

        UniCloudStartEcsResp resp = UniCloudFactory.Ecs.start(req);
        System.out.println("---云主机开机---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 云主机重启
     */
    @Test
    public void reboot() throws Exception {
        UniCloudRebootEcsReq req = new UniCloudRebootEcsReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-kec2yg1gkmvs");

        UniCloudRebootEcsResp resp = UniCloudFactory.Ecs.reboot(req);
        System.out.println("---云主机关机---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 修改云主机名称
     */
    @Test
    public void updateEcsName() throws Exception {
        UniCloudUpdateEcsNameReq req = new UniCloudUpdateEcsNameReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-keck47xwtk7c");
        req.setInstanceName("xinput111");

        UniCloudUpdateEcsNameResp resp = UniCloudFactory.Ecs.updateEcsName(req);
        System.out.println("---修改云主机名称---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 修改云主机密码
     */
    @Test
    public void updatePassword() throws Exception {
        UniCloudResetEcsPasswordReq req = new UniCloudResetEcsPasswordReq();

        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-keck47xwtk7c");
        req.setPassword("1234567890");

        UniCloudResetEcsPasswordResp resp = UniCloudFactory.Ecs.updatePassword(req);
        System.out.println("---修改云主机名称---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 云主机关机
     */
    @Test
    public void stop() throws Exception {
        UniCloudStopEcsReq req = new UniCloudStopEcsReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-kec2yg1gkmvs");

        UniCloudStopEcsResp resp = UniCloudFactory.Ecs.stop(req);
        System.out.println("---云主机关机---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 删除云主机
     */
    @Test
    public void delete() throws Exception {
        UniCloudDeleteEcsReq req = new UniCloudDeleteEcsReq();

        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("ecs-kd9jlj5huacm");

        UniCloudDeleteEcsResp resp = UniCloudFactory.Ecs.delete(req);
        System.out.println("---删除云主机---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 删除并关机
     */
    @Test
    public void closeAndDelete() throws Exception {
        String instanceId = "ecs-kec2bq5txth4";

        UniCloudStopEcsReq stopEcsReq = new UniCloudStopEcsReq();
        stopEcsReq.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        stopEcsReq.setInstanceId(instanceId);

        UniCloudStopEcsResp stopEcsResp = UniCloudFactory.Ecs.stop(stopEcsReq);

        UniCloudDeleteEcsReq req = new UniCloudDeleteEcsReq();

        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId(instanceId);

        UniCloudDeleteEcsResp resp = UniCloudFactory.Ecs.delete(req);
    }
}
