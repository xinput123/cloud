package com.unicloud.demo;

import com.xinput.cloud.Cloud;
import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.domain.CloudConfig;
import com.xinput.cloud.domain.req.DeleteEcsReq;
import com.xinput.cloud.domain.req.DescribeEcsReq;
import com.xinput.cloud.domain.req.DetailEcsReq;
import com.xinput.cloud.domain.req.RunEcsReq;
import com.xinput.cloud.domain.req.StartEcsReq;
import com.xinput.cloud.domain.req.StopEcsReq;
import com.xinput.cloud.domain.resp.DeleteEcsResp;
import com.xinput.cloud.domain.resp.DetailEcsResp;
import com.xinput.cloud.domain.resp.RunEcsResp;
import com.xinput.cloud.domain.resp.StartEcsResp;
import com.xinput.cloud.domain.resp.StopEcsResp;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 14:48
 */
public class UniCloudDemo {

    @Before
    public void init() throws ParamException {
        CloudConfig config = new CloudConfig();
        config.setAccessKey("xxx");
        config.setSecretKey("xxx");
        Cloud.initCloud(config);
    }

    @Test
    public void decs() throws Exception {
        DescribeEcsReq describeEcsReq = new DescribeEcsReq();
        describeEcsReq.setRegion(CloudConsts.Region.UNICLOUD_HB1_BJ3);
        Cloud.describeEcs(describeEcsReq);
    }

    /**
     * 云主机实例详情
     */
    @Test
    public void detailEcs() throws Exception {
        DetailEcsReq detailEcsReq = new DetailEcsReq();
        detailEcsReq.setRegion(CloudConsts.Region.UNICLOUD_HB1_BJ3)
                .setInstanceId("ecs-kdy4iy46l6j7");

        DetailEcsResp detailEcsResp = Cloud.detailEcs(detailEcsReq);
        System.out.println("\n\n\n=================");
        System.out.println(JsonUtils.toJsonString(detailEcsResp, true));
    }

    /**
     * 创建并运行一个主机
     *
     * @throws Exception
     */
    @Test
    public void runEcs() throws Exception {
        RunEcsReq runEcsReq = new RunEcsReq();
        runEcsReq.setRegion(CloudConsts.Region.UNICLOUD_HB1_BJ3);
        runEcsReq.setAzoneId("HB1-BJMY2");
        runEcsReq.setPayType(CloudConsts.PayTypeEnum.UNICLOUD_CHARGING_HOURS);
        runEcsReq.setVmSpecificationCode(CloudConsts.VmSpecificationCode.UNICLOUD_C1_MEDIUM_2.getCode());
        runEcsReq.setSysDiskSpecificationCode("ebs.hybrid.hdd");
        runEcsReq.setSysDiskSize(40);

        runEcsReq.setImageId("img-kdrbc1quczhw");
        runEcsReq.setImageSpecificationClassCode("ecs.image.private");

        runEcsReq.setVpcId("vpc-eyxzmew8kagpb");

        runEcsReq.setPassword("yuan1234");
        runEcsReq.setInstanceName("xinput");
        runEcsReq.setHostName("xinput-host");
        runEcsReq.setDescription("这是一台测试机，通过接口开启");
        runEcsReq.setBaseQuantity(1);
        runEcsReq.setInitialShell("echo 123456-xinput");

        runEcsReq.setSecurityGroupId("sg-j3xtbqhydigpb");
        runEcsReq.setMasterEniSubNetId("8bd69b53fcf349058bb01c2efb4d8593");

        RunEcsResp runEcsResp = Cloud.runEcs(runEcsReq);
        System.out.println(JsonUtils.toJsonString(runEcsResp, true));
    }

    /**
     * 关机
     *
     * @throws Exception
     */
    @Test
    public void stopEcs() throws Exception {
        StopEcsReq stopEcsReq = new StopEcsReq();
        stopEcsReq.setRegion(CloudConsts.Region.UNICLOUD_HB1_BJ3);
        stopEcsReq.setInstanceId("ecs-kd24pr6qdpko");
        // 紫光云主机ID不存在时，也会返回成功
//        stopEcsReq.setInstanceId("ecs-kdy4iy46l6j8");

        StopEcsResp stopEcsResp = Cloud.stopEcs(stopEcsReq);
        System.out.println("\n\n\n=================");
        System.out.println(JsonUtils.toJsonString(stopEcsResp, true));
    }

    /**
     * 开机
     *
     * @throws Exception
     */
    @Test
    public void startEcs() throws Exception {
        StartEcsReq startEcsReq = new StartEcsReq();
        startEcsReq.setRegion(CloudConsts.Region.UNICLOUD_HB1_BJ3);
        startEcsReq.setInstanceId("ecs-kd24pr6qdpko");

        StartEcsResp startEcsResp = Cloud.startEcs(startEcsReq);
        System.out.println("\n\n\n=======开机响应值==========");
        System.out.println(JsonUtils.toJsonString(startEcsResp, true));
    }

    /**
     * 删除主机
     *
     * @throws Exception
     */
    @Test
    public void deleteEcs() throws Exception {
        DeleteEcsReq deleteEcsReq = new DeleteEcsReq();
        deleteEcsReq.setRegion(CloudConsts.Region.UNICLOUD_HB1_BJ3);
        deleteEcsReq.setInstanceId("ecs-kd24pr6qdpko");

        DeleteEcsResp deleteEcsResp = Cloud.deleteEcs(deleteEcsReq);
        System.out.println("\n\n\n=======删除主机响应值==========");
        System.out.println(JsonUtils.toJsonString(deleteEcsResp, true));
    }
}
