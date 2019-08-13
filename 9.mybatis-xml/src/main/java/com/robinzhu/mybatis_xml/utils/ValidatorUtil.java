package com.robinzhu.mybatis_xml.utils;

import com.robinzhu.mybatis_xml.entity.CommonException;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Create by zhudapeng
 * 2019-08-11 13:08
 *
 * 对于已有的注释无法满足校验要求时，也可以自定义注释的开发
 */
public class ValidatorUtil {
    private static Validator validator = ((HibernateValidatorConfiguration) Validation.byProvider(HibernateValidator.class).configure()).failFast(true).buildValidatorFactory().getValidator();

    public static <T> void validate(T obj) throws CommonException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj, new Class[0]);
        if (constraintViolations.size() > 0) {
            ConstraintViolation<T> validateInfo = (ConstraintViolation<T>) constraintViolations.iterator().next();
            // validateInfo.getMessage() 验证不通过时的信息，即message对应的值
            throw new CommonException(1, validateInfo.getMessage(), null);
        }
    }
}
