package com.xinput.unicloud.model.response.keypair;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 删除密钥对 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDeleteKeyPairResp extends UniResponse {
    @Override
    public boolean isSuccess() {
        return true;
    }
}
