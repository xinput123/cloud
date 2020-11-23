package com.xinput.unicloud;

import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudCreateVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeVpcReq;
import com.xinput.unicloud.model.response.vpc.UniCloudCreateVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeVpcResp;
import com.xinput.unicloud.util.UniCloudFactory;
import org.junit.Before;
import org.junit.Test;

/**
 * Vpc api
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-22 16:47
 */
public class UniCloudVpcApiCase {

    @Before
    public void init() throws ParamException {
        String ak = "xxx";
        String sk = "xxx";
        UniCloudFactory.init(ak, sk);
    }

    /**
     * 创建vpn网络
     */
    @Test
    public void createVpc() throws Exception {
        UniCloudCreateVpcReq req = new UniCloudCreateVpcReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceCode("vpc.standard");
        req.setVpcName("xinput");
        req.setVpcCidrBlock("192.172.0.0/16");
        req.setSubnetName("xinput-sub");
        req.setSubnetCidrBlock("192.172.3.0/24");

        UniCloudCreateVpcResp resp = UniCloudFactory.Vpc.create(req);
        System.out.println("---创建vpn网络---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 查看vpc列表
     */
    @Test
    public void describe() throws Exception {
        UniCloudDescribeVpcReq req = new UniCloudDescribeVpcReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());

        UniCloudDescribeVpcResp resp = UniCloudFactory.Vpc.describe(req);
        System.out.println("---查看vpc列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 删除vpn网络
     */
    @Test
    public void deleteVpc() throws Exception {
        UniCloudDeleteVpcReq req = new UniCloudDeleteVpcReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("vpc-bpmz34ie4pgpb");

        UniCloudDeleteVpcResp resp = UniCloudFactory.Vpc.delete(req);
        System.out.println("---删除vpn网络---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }
}
