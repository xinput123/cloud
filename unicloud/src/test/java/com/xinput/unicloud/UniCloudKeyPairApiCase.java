package com.xinput.unicloud;

import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudCreateKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudDeleteKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudDescribeKeyPairReq;
import com.xinput.unicloud.model.reqeust.keypair.UniCloudGetVmByKeyPairReq;
import com.xinput.unicloud.model.response.keypair.UniCloudCreateKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudDeleteKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudDescribeKeyPairResp;
import com.xinput.unicloud.model.response.keypair.UniCloudGetVmByKeyPairResp;
import com.xinput.unicloud.util.UniCloudFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * 密钥对测试用例
 */
public class UniCloudKeyPairApiCase {

    @Before
    public void init() throws ParamException {
        String ak = "xxx";
        String sk = "xxx";
        UniCloudFactory.init(ak, sk);
    }

    /**
     * 创建秘钥
     */
    @Test
    public void createKeyPairs() throws Exception {
        UniCloudCreateKeyPairReq req = new UniCloudCreateKeyPairReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setName("xinput3");
        UniCloudCreateKeyPairResp resp = UniCloudFactory.KeyPair.create(req);
        System.out.println("---创建密钥对---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 删除密钥对
     */
    @Test
    public void deleteKeyPairs() throws Exception {
        UniCloudDeleteKeyPairReq req = new UniCloudDeleteKeyPairReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("kp-keaqb2qjabp7");
        UniCloudDeleteKeyPairResp resp = UniCloudFactory.KeyPair.delete(req);
        System.out.println("---删除密钥对---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 密钥对列表
     */
    @Test
    public void describeKeyPairs() throws Exception {
        UniCloudDescribeKeyPairReq req = new UniCloudDescribeKeyPairReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());

        UniCloudDescribeKeyPairResp resp = UniCloudFactory.KeyPair.describe(req);
        System.out.println("---密钥对列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 获取应用密钥对的云主机
     */
    @Test
    public void getVMByKeyPair() throws Exception {
        UniCloudGetVmByKeyPairReq req = new UniCloudGetVmByKeyPairReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("kp-keaqb2qjabp7");

        UniCloudGetVmByKeyPairResp resp = UniCloudFactory.KeyPair.getVm(req);
        System.out.println("---获取应用密钥对的云主机---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }
}
