package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.domain.req.DeleteEcsReq;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 使用DeleteEcs释放云主机
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:10
 */
public class UniCloudDeleteEcsReq extends UniRequest {

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

    public UniCloudDeleteEcsReq(@NotNull(message = "对象[deleteEcsReq]不能为空") DeleteEcsReq deleteEcsReq) {
        super.setAction(UniCloudConsts.Action.STOP_ECS.getAction());
        if (deleteEcsReq.getRegion() != null) {
            super.setRegionId(deleteEcsReq.getRegion().getRegionId());
        }
        this.instanceId = deleteEcsReq.getInstanceId();
    }

    @Override
    public void checkConstraints() throws ParamException {
        if (!StringUtils.equalsIgnoreCase(UniCloudConsts.Action.STOP_ECS.getAction(), this.getAction())) {
            this.setAction(UniCloudConsts.Action.STOP_ECS.getAction());
        }

        this.checkField();
    }
}
