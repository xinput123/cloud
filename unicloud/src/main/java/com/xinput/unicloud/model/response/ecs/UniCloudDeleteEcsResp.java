package com.xinput.unicloud.model.response.ecs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 使用DeleteEcs释放云主机 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDeleteEcsResp extends UniResponse {
    @Override
    public boolean isSuccess() {
        if (StringUtils.isEmpty(this.getCode())) {
            return true;
        }
        return false;
    }
}
