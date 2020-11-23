package com.xinput.unicloud.model.reqeust.image;

import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;

/**
 * 释放私有镜像 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDeleteImageReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：镜像ID
     */
    @NotEmpty(message = "字段 [imageId] 不能为空")
    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public void checkConstraints() throws ParamException {
        if (!StringUtils.equalsIgnoreCase(UniCloudConsts.Action.DELETE_IMAGES.getAction(), this.getAction())) {
            this.setAction(UniCloudConsts.Action.DELETE_IMAGES.getAction());
        }

        this.checkField();
    }
}
