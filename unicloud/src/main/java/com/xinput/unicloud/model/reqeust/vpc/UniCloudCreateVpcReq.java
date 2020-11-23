package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 创建一个专有网络 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudCreateVpcReq extends UniRequest {

    /**
     * 类型：string
     * 必选：是
     * 描述：VPC 实例规格，默认为:vpc.standard
     */
    @NotEmpty(message = "字段 [instanceCode] 不能为空")
    private String instanceCode;

    /**
     * 类型：string
     * 必选：是
     * 描述：VPC 的名称。有效长度为 2~15 个字符，以 字母为首位，由大小写字母、数字组成
     */
    @Size(min = 2, max = 15, message = "字段 [vpcName] 有效长度为 2~15 个字符")
    private String vpcName;

    /**
     * 类型：string
     * 必选：是
     * 描述：VPC 的网段。推荐值为:10.0.0.0/8-24; 172.16.0.0/12-24; 192.168.0.0/16-24
     */
    @NotEmpty(message = "字段 [vpcCidrBlock] 不能为空")
    private String vpcCidrBlock;

    /**
     * 类型：string
     * 必选：是
     * 描述：子网名称。有效长度为 2~15 个字符，以字母 为首位，由大小写字母、数字组成。
     */
    @Size(min = 2, max = 15, message = "字段 [subnetName] 有效长度为 2~15 个字符")
    private String subnetName;

    /**
     * 类型：string
     * 必选：是
     * 描述：子网名称。有效长度为 2~15 个字符，以字母 为首位，由大小写字母、数字组成。
     */
    @Size(min = 2, max = 15, message = "字段 [subnetCidrBlock] 有效长度为 2~15 个字符")
    private String subnetCidrBlock;

    public String getInstanceCode() {
        return instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
        this.instanceCode = instanceCode;
    }

    public String getVpcName() {
        return vpcName;
    }

    public void setVpcName(String vpcName) {
        this.vpcName = vpcName;
    }

    public String getVpcCidrBlock() {
        return vpcCidrBlock;
    }

    public void setVpcCidrBlock(String vpcCidrBlock) {
        this.vpcCidrBlock = vpcCidrBlock;
    }

    public String getSubnetName() {
        return subnetName;
    }

    public void setSubnetName(String subnetName) {
        this.subnetName = subnetName;
    }

    public String getSubnetCidrBlock() {
        return subnetCidrBlock;
    }

    public void setSubnetCidrBlock(String subnetCidrBlock) {
        this.subnetCidrBlock = subnetCidrBlock;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.CREATE_VPC.getAction());
        this.checkField();
    }
}
