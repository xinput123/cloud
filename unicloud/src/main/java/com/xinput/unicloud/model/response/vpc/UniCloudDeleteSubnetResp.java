package com.xinput.unicloud.model.response.vpc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 删除子网 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDeleteSubnetResp extends UniResponse {

    /**
     * 请求结果描述
     */
    @JsonProperty(value = "Msg")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean isSuccess() {
        if (StringUtils.equalsIgnoreCase("Network.Success", this.getCode())) {
            return true;
        }
        return false;
    }
}
