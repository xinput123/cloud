package com.xinput.unicloud.model.reqeust.vpc;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 查询子网列表 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDescribeSubnetReq extends UniRequest {

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

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DESCRIBE_SUBNET.getAction());
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
        return HttpUtils.get(url);
    }
}
