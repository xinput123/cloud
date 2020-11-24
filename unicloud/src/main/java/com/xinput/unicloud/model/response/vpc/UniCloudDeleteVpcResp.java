package com.xinput.unicloud.model.response.vpc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 删除VPC专有网络 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDeleteVpcResp extends UniResponse {

    @Override
    public boolean isSuccess() {
        if (StringUtils.equalsIgnoreCase("Network.Success", this.getCode())) {
            return true;
        }
        return false;
    }
}
