package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.domain.req.StartEcsReq;
import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 使用StartEcs对云主机开机
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:10
 */
public class UniCloudStartEcsReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：云主机实例ID
     */
    @NotEmpty(message = "字段 [instanceId] 不能为空")
    private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public UniCloudStartEcsReq(@NotNull(message = "对象[startEcsReq]不能为空") StartEcsReq startEcsReq) {
        if (startEcsReq.getRegion() != null) {
            super.setRegionId(startEcsReq.getRegion().getRegionId());
        }
        this.instanceId = startEcsReq.getInstanceId();
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.START_ECS.getAction());
        this.checkField();
    }
}
