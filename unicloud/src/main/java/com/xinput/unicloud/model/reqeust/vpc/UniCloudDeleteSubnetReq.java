package com.xinput.unicloud.model.reqeust.vpc;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 释放指定 VPC 下的指定子网 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDeleteSubnetReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：指定 VPC 实例的 ID
     */
    @NotEmpty(message = "字段 [vpcId] 不能为空")
    private String vpcId;

    /**
     * 类型：String
     * 必选：是
     * 描述：子网 Id
     */
    @NotEmpty(message = "字段 [subnetId] 不能为空")
    private String subnetId;

    public String getSubnetId() {
        return subnetId;
    }

    public void setSubnetId(String subnetId) {
        this.subnetId = subnetId;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DELETE_SUBNET.getAction());
        this.checkField();
    }

    @Override
    public Map<String, Object> signatureParams() {
        Map<String, Object> params = this.toMap();
        this.addCommonParams(params);
        return params;
    }

    @Override
    public String httpExecute(String url) throws Exception {
        return HttpUtils.delete(url);
    }
}
