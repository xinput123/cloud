package com.xinput.unicloud.model.reqeust.image;

import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 创建系统盘快照 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudCreateEcsSysSnapshotReq extends UniRequest {

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
     * 描述：快照名
     */
    @NotEmpty(message = "字段 [name] 不能为空")
    private String name;

    /**
     * 类型：String
     * 必选：否
     * 描述：快照描述
     */
    private String description;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void checkConstraints() throws ParamException {
        if (!StringUtils.equalsIgnoreCase(UniCloudConsts.Action.CREATE_ECS_SYS_SNAPSHOT.getAction(), this.getAction())) {
            this.setAction(UniCloudConsts.Action.CREATE_ECS_SYS_SNAPSHOT.getAction());
        }

        this.checkField();
    }
}
