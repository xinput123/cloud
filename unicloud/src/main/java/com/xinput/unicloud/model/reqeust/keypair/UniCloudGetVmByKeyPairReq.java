package com.xinput.unicloud.model.reqeust.keypair;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 获取应用密钥对的云主机 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudGetVmByKeyPairReq extends UniRequest {

    /**
     * 类型：string
     * 必选：是
     * 描述：页码
     */
    @NotEmpty(message = "字段 [instanceId] 不能为空")
    private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.GET_VM_BY_KEY_PAIR.getAction());
        this.checkField();
    }
}
