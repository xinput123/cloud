package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 修改云主机名称 请求值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:10
 */
public class UniCloudUpdateEcsNameReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：云主机实例ID
     */
    @NotEmpty(message = "字段 [instanceId] 不能为空")
    private String instanceId;

    /**
     * 类型：String
     * 必选：是
     * 描述：云主机实例名称
     */
    @NotEmpty(message = "字段 [instanceName] 不能为空")
    private String instanceName;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public UniCloudUpdateEcsNameReq() {
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.UPDATE_ECS_NAME.getAction());
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
