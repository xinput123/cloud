package com.xinput.cloud.domain.resp;

/**
 * 开启云主机响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:34
 */
public class StartEcsResp {

    /**
     * 操作是否成功
     */
    private boolean success;

    private String requestId;

    private String code;

    private String message;

    public String getRequestId() {
        return requestId;
    }

    public StartEcsResp setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public boolean getSuccess() {
        return success;
    }

    public StartEcsResp setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return code;
    }

    public StartEcsResp setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public StartEcsResp setMessage(String message) {
        this.message = message;
        return this;
    }
}
