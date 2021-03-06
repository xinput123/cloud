package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

/**
 * 查询已创建的VPC列表 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDescribeVpcReq extends UniRequest {

    /**
     * 类型：String
     * 必选：否
     * 描述：指定 VPC 实例的名称
     */
    private String name;

    /**
     * 类型：String
     * 必选：否
     * 描述：指定 VPC 实例的 ID
     */
    private String vpcId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DESCRIBE_VPC.getAction());
        this.checkField();

    }

}
