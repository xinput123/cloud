package com.xinput.unicloud.model.response.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 生成私有镜像 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudCreateImageResp extends UniResponse {

    /**
     * 镜像ID
     */
    private String imageId;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public boolean isSuccess() {
        if (StringUtils.isNotEmpty(imageId)) {
            return true;
        }
        return false;
    }
}
