package com.xinput.unicloud;

import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.JsonUtils;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudCreateSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudCreateVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDeleteVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeSubnetReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudDescribeVpcReq;
import com.xinput.unicloud.model.reqeust.vpc.UniCloudUpdateVpcReq;
import com.xinput.unicloud.model.response.vpc.UniCloudCreateSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudCreateVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDeleteVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeSubnetResp;
import com.xinput.unicloud.model.response.vpc.UniCloudDescribeVpcResp;
import com.xinput.unicloud.model.response.vpc.UniCloudUpdateVpcResp;
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
        req.setVpcName("xinput1");
        req.setVpcCidrBlock("192.172.0.0/16");
        req.setSubnetName("xinput-sub");
        req.setSubnetCidrBlock("192.172.1.0/24");

        UniCloudCreateVpcResp resp = UniCloudFactory.Vpc.create(req);
        System.out.println("---创建vpn网络---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
        System.out.println("---创建vpn网络是否成功---" + resp.isSuccess());
    }

    /**
     * 查看vpc列表
     */
    @Test
    public void describe() throws Exception {
        UniCloudDescribeVpcReq req = new UniCloudDescribeVpcReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setVpcId("vpc-5xv4tb4pxtgpb");

        UniCloudDescribeVpcResp resp = UniCloudFactory.Vpc.describe(req);
        System.out.println("---查看vpc列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 修改vpn网络名称
     */
    @Test
    public void update() throws Exception {
        UniCloudUpdateVpcReq req = new UniCloudUpdateVpcReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setVpcId("vpc-5xv4tb4pxtgpb");
        req.setName("xinput-test");

        UniCloudUpdateVpcResp resp = UniCloudFactory.Vpc.updateVpc(req);
        System.out.println("---修改vpn网络名称---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 删除vpn网络
     */
    @Test
    public void deleteVpc() throws Exception {
        UniCloudDeleteVpcReq req = new UniCloudDeleteVpcReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setInstanceId("vpc-5xv4tb4pxtgpb");

        UniCloudDeleteVpcResp resp = UniCloudFactory.Vpc.delete(req);
        System.out.println("---删除vpn网络---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 创建子网
     */
    @Test
    public void createSubnet() throws Exception {
        UniCloudCreateSubnetReq req = new UniCloudCreateSubnetReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setVpcId("vpc-5xv4tb4pxtgpb");
        req.setName("xinput-2");
        req.setCidr("192.172.3.0/24");

        UniCloudCreateSubnetResp resp = UniCloudFactory.Vpc.createSubnet(req);
        System.out.println("---子网列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 子网列表
     */
    @Test
    public void describeSubnet() throws Exception {
        UniCloudDescribeSubnetReq req = new UniCloudDescribeSubnetReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setVpcId("vpc-5xv4tb4pxtgpb");

        UniCloudDescribeSubnetResp resp = UniCloudFactory.Vpc.describeSubnet(req);
        System.out.println("---子网列表---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }

    /**
     * 删除指定子网
     */
    @Test
    public void deleteSubnet() throws Exception {
        UniCloudDeleteSubnetReq req = new UniCloudDeleteSubnetReq();
        req.setRegionId(CloudConsts.Region.UNICLOUD_HB1_BJ3.getRegionId());
        req.setVpcId("vpc-5xv4tb4pxtgpb");
        req.setSubnetId("3be5444e9b4642109e54b763b8cae69e");

        UniCloudDeleteSubnetResp resp = UniCloudFactory.Vpc.deleteSubnet(req);
        System.out.println("---删除指定子网---\n\n\n");
        System.out.println(JsonUtils.toJsonString(resp, true));
    }
}
