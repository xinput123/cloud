package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;
import com.xinput.unicloud.util.HttpUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * 修改云主机密码
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:10
 */
public class UniCloudResetEcsPasswordReq extends UniRequest {

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
     * 描述：云主机密码
     */
    @NotEmpty(message = "字段 [password] 不能为空")
    private String password;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UniCloudResetEcsPasswordReq() {
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.RESET_ECS_PASSWORD.getAction());
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
