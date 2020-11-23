package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniSubnetRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 创建子网 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudCreateSubnetReq extends UniSubnetRequest {

    /**
     * 类型：string
     * 必选：是
     * 描述：子网名称
     */
    @NotEmpty(message = "字段 [name] 不能为空")
    private String name;

    /**
     * 类型：string
     * 必选：是
     * 描述：子网的 CIDR
     */
    @NotEmpty(message = "字段 [cidr] 不能为空")
    private String cidr;

    /**
     * 类型：string
     * 必选：是
     * 描述：网关
     */
    private String gatewayIp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public String getGatewayIp() {
        return gatewayIp;
    }

    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.CREATE_SUBNET.getAction());
        this.checkField();
    }
}
