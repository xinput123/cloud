package com.xinput.unicloud.model.reqeust.vpc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;
import java.util.HashMap;
import java.util.Map;

/**
 * 创建子网 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudCreateSubnetReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：VPC 实例
     */
    @JsonIgnore
    @NotEmpty(message = "字段 [vpcId] 不能为空")
    private String vpcId;

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

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

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

    @Override
    public Map<String, Object> signatureParams() {
        Map<String, Object> params = new HashMap();
        params.put("Action", this.getAction());
        params.put("RegionId", this.getRegionId());
        params.put("VpcId", this.vpcId);
        this.addCommonParams(params);
        return params;
    }

    @Override
    public String httpExecute(String url) throws Exception {
        return HttpUtils.post(url, this);
    }
}
