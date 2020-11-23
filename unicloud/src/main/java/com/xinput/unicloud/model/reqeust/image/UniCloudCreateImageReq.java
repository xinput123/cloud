package com.xinput.unicloud.model.reqeust.image;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 生成私有镜像 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudCreateImageReq extends UniRequest {

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
     * 描述：镜像名筛选
     */
    @NotEmpty(message = "字段 [imageName] 不能为空")
    private String imageName;

    /**
     * 类型：String
     * 必选：否
     * 描述：镜像描述
     */
    private String description;

    /**
     * 类型：boolean
     * 必选：否
     * 描述：镜像中是否带数据盘信息
     */
    private boolean WithDataDisks;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWithDataDisks() {
        return WithDataDisks;
    }

    public void setWithDataDisks(boolean withDataDisks) {
        WithDataDisks = withDataDisks;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.CREATE_IMAGE.getAction());
        this.checkField();
    }
}
