package com.xinput.unicloud.model.response.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 释放私有镜像 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDeleteImageResp extends UniResponse {

    @Override
    public boolean isSuccess() {
        return true;
    }
}
