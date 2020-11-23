package com.xinput.unicloud.model.reqeust;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 10:42
 */
public abstract class UniSubnetRequest extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：VPC 实例
     */
    @JsonIgnore
    @NotEmpty(message = "字段 [vpcId] 不能为空")
    private String vpcId;

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }
}
