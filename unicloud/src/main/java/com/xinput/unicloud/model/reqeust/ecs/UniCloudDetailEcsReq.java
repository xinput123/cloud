package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.domain.req.DetailEcsReq;
import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 查询云主机实例参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 17:52
 */
public class UniCloudDetailEcsReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：云主机ID
     */
    @NotEmpty(message = "字段 [instanceId] 不能为空")
    private String instanceId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public UniCloudDetailEcsReq(DetailEcsReq detailEcsReq) {
        if (detailEcsReq.getRegion() != null) {
            super.setRegionId(detailEcsReq.getRegion().getRegionId());
        }
        this.instanceId = detailEcsReq.getInstanceId();
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DETAIL_ECS.getAction());
        checkField();
    }
}
