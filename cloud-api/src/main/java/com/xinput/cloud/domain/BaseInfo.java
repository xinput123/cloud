package com.xinput.cloud.domain;

import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.ValidateUtils;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-17 15:18
 */
public abstract class BaseInfo {

    /**
     * 检查约束情况.
     */
    public abstract void checkConstraints() throws ParamException;

    protected void checkField() throws ParamException {
        ValidateUtils.validate(this);
    }
}
