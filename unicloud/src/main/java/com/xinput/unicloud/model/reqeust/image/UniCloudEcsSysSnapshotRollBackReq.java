package com.xinput.unicloud.model.reqeust.image;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 进行系统盘快照回滚 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudEcsSysSnapshotRollBackReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：云主机ID
     */
    @NotEmpty(message = "字段 [instanceId] 不能为空")
    private String instanceId;

    /**
     * 类型：String
     * 必选：是
     * 描述：快照ID
     */
    @NotEmpty(message = "字段 [snapshotId] 不能为空")
    private String snapshotId;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.ECS_SYS_SNAPSHOT_ROLLBACK.getAction());
        this.checkField();
    }
}
