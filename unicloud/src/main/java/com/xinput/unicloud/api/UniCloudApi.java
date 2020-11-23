package com.xinput.unicloud.api;

import com.xinput.cloud.api.CloudApi;
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
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDeleteEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDescribeEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudDetailEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudRunEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStartEcsReq;
import com.xinput.unicloud.model.reqeust.ecs.UniCloudStopEcsReq;
import com.xinput.unicloud.model.response.ecs.UniCloudDeleteEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudDetailEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudRunEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStartEcsResp;
import com.xinput.unicloud.model.response.ecs.UniCloudStopEcsResp;
import com.xinput.unicloud.util.UniCloudFactory;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-18 17:42
 */
public class UniCloudApi implements CloudApi {

    @Override
    public void initCloud(CloudConfig cloudConfig) throws ParamException {
        cloudConfig.checkConstraints();
        UniCloudFactory.init(cloudConfig.getAccessKey(), cloudConfig.getSecretKey());
    }

    @Override
    public void describeEcs(DescribeEcsReq describeEcsReq) throws Exception {
        UniCloudDescribeEcsReq uniCloudDescribeEcsReq = new UniCloudDescribeEcsReq(describeEcsReq);
        UniCloudFactory.Ecs.describeEcs(uniCloudDescribeEcsReq);
    }

    @Override
    public DetailEcsResp detailEcs(DetailEcsReq detailEcsReq) throws Exception {
        UniCloudDetailEcsResp uniCloudDetailEcsResp =
                UniCloudFactory.Ecs.detailEcs(new UniCloudDetailEcsReq(detailEcsReq));
        return new DetailEcsResp()
                .setRequestId(uniCloudDetailEcsResp.getRequestId())
                .setInstanceId(uniCloudDetailEcsResp.getId())
                .setInstanceName(uniCloudDetailEcsResp.getName())
                .setRegionId(uniCloudDetailEcsResp.getRegionId())
                .setRegionName(uniCloudDetailEcsResp.getRegionName())
                .setStatus(uniCloudDetailEcsResp.getStatus())
                .setIp(uniCloudDetailEcsResp.getIp());
    }

    @Override
    public RunEcsResp runEcs(RunEcsReq runEcsReq) throws Exception {
        UniCloudRunEcsResp uniCloudRunEcsResp =
                UniCloudFactory.Ecs.runEcs(new UniCloudRunEcsReq(runEcsReq));
        System.out.println(JsonUtils.toJsonString(uniCloudRunEcsResp, true));
        return new RunEcsResp()
                .setRequestId(uniCloudRunEcsResp.getRequestId())
                .setOrderId(uniCloudRunEcsResp.getOrderId())
                .setInstanceIds(uniCloudRunEcsResp.getInstanceIds());
    }

    @Override
    public void renewEcs() throws Exception {

    }

    @Override
    public StartEcsResp startEcs(StartEcsReq startEcsReq) throws Exception {
        UniCloudStartEcsResp uniCloudStartEcsResp =
                UniCloudFactory.Ecs.startEcs(new UniCloudStartEcsReq(startEcsReq));
        StartEcsResp startEcsResp = new StartEcsResp();
        startEcsResp.setRequestId(uniCloudStartEcsResp.getRequestId())
                .setCode(uniCloudStartEcsResp.getCode())
                .setMessage(uniCloudStartEcsResp.getMessage());

        String code = uniCloudStartEcsResp.getCode();
        if (StringUtils.isEmpty(code) || StringUtils.equalsIgnoreCase("Instance.StartStatus", code)) {
            startEcsResp.setSuccess(true);
        }
        return startEcsResp;
    }

    @Override
    public StopEcsResp stopEcs(StopEcsReq stopEcsReq) throws Exception {
        UniCloudStopEcsResp uniCloudStopEcsResp =
                UniCloudFactory.Ecs.stopEcs(new UniCloudStopEcsReq(stopEcsReq));
        StopEcsResp stopEcsResp = new StopEcsResp();
        stopEcsResp.setRequestId(uniCloudStopEcsResp.getRequestId())
                .setCode(uniCloudStopEcsResp.getCode())
                .setMessage(uniCloudStopEcsResp.getMessage());

        String code = uniCloudStopEcsResp.getCode();
        if (StringUtils.isEmpty(code) || StringUtils.equalsIgnoreCase("Instance.ShutDownStatus", code)) {
            stopEcsResp.setSuccess(true);
        }

        return stopEcsResp;
    }

    @Override
    public void rebootEcs() throws Exception {

    }

    @Override
    public void updateEcsName() throws Exception {

    }

    @Override
    public void rebuildEcs() throws Exception {

    }

    @Override
    public void resetEcsPassword() throws Exception {

    }

    @Override
    public DeleteEcsResp deleteEcs(DeleteEcsReq deleteEcsReq) throws Exception {
        UniCloudDeleteEcsResp uniCloudDeleteEcsResp =
                UniCloudFactory.Ecs.deleteECs(new UniCloudDeleteEcsReq(deleteEcsReq));
        DeleteEcsResp deleteEcsResp = new DeleteEcsResp();
        deleteEcsResp.setRequestId(uniCloudDeleteEcsResp.getRequestId())
                .setCode(uniCloudDeleteEcsResp.getCode())
                .setMessage(uniCloudDeleteEcsResp.getMessage());

        String code = uniCloudDeleteEcsResp.getCode();
        if (StringUtils.isEmpty(code) || StringUtils.equalsIgnoreCase("Instance.ShutDownStatus", code)) {
            deleteEcsResp.setSuccess(true);
        }

        return deleteEcsResp;
    }

    @Override
    public void updateEcsConfig() throws Exception {

    }

    @Override
    public void getEcsPassword() throws Exception {

    }

    @Override
    public void resizeEcsSystemDisk() throws Exception {

    }

    @Override
    public void monitor() throws Exception {

    }

    @Override
    public void ecsAttachDisk() throws Exception {

    }

    @Override
    public void ecsDetachDisk() throws Exception {

    }

    @Override
    public void describeImages() throws Exception {

    }

    @Override
    public void createImage() throws Exception {

    }

    @Override
    public void deleteImages() throws Exception {

    }

    @Override
    public void createEcsSysSnapshot() throws Exception {

    }

    @Override
    public void ecsSysSnapshotRollBack() throws Exception {

    }

    @Override
    public void describeKeyPairs() throws Exception {

    }

    @Override
    public void createKeyPair() throws Exception {

    }

    @Override
    public void deleteKeyPairs() throws Exception {

    }

    @Override
    public void getEcsByKeyPair() throws Exception {

    }
}
