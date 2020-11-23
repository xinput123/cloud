package com.xinput.cloud.util;

import com.xinput.cloud.exception.ParamException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-09-29 10:53
 */
public class ValidateUtils {

    public static <T> void validate(T t) throws ParamException {
        if (null == t) {
            throw new ParamException("参数为空");
        }

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            if (StringUtils.isNotEmpty(constraintViolation.getMessage())) {
                throw new ParamException(constraintViolation.getMessage());
            }
        }
    }
}
