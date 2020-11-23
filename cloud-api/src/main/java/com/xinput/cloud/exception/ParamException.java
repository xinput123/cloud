package com.xinput.cloud.exception;

/**
 * 参数异常，不合法
 */
public class ParamException extends Exception {

    public ParamException(String message) {
        super(message);
    }

    public ParamException(Throwable cause) {
        super(cause);
    }

    public ParamException(String message, Throwable cause) {
        super(message, cause);
    }

}
