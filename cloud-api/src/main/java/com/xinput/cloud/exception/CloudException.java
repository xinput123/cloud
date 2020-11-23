package com.xinput.cloud.exception;

/**
 * 云接口异常
 */
public class CloudException extends BaseException {

    public CloudException(String message) {
        super(message);
    }

    public CloudException(Throwable cause) {
        super(cause);
    }

    public CloudException(String message, Throwable cause) {
        super(message, cause);
    }

}
