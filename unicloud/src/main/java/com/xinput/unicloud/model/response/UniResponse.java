package com.xinput.unicloud.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 18:15
 */
public abstract class UniResponse {

    /**
     * 请求Id
     */
    @JsonProperty("RequestId")
    private String requestId;

    /**
     * 状态编码
     */
    @JsonProperty("Code")
    private String code;

    /**
     * 提示信息
     */
    @JsonProperty("Message")
    private String message;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 当前请求是否成功
     */
    public abstract boolean isSuccess();
}
