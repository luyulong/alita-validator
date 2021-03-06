package top.klw8.alita.validator.annotations.impl;

import java.lang.annotation.Annotation;

import top.klw8.alita.validator.IAnnotationsValidator;
import top.klw8.alita.validator.ValidatorException;
import top.klw8.alita.validator.ValidatorImpl;
import top.klw8.alita.validator.annotations.Required;
import top.klw8.alita.validator.utils.ValidatorUtil;


/**
 * @author klw
 * @ClassName: RequiredImpl
 * @Description: 必传参数注解, 使用该注解的参数为必传参数.此注解仅验证参数是否为null, 不管其他, 如需要验证格式等请配合其他注解一起使用
 * @date 2018年9月17日 13:11:39
 */
@ValidatorImpl(validator = Required.class)
public class RequiredImpl implements IAnnotationsValidator {

    @Override
    public void doValidator(Object object, Annotation annotation) throws ValidatorException {
        Required required = (Required) annotation;
        String statusCode = required.responseStatusCode();
        String message = required.validatFailMessage();
        ValidatorUtil.notNull(object, statusCode, message);
    }

}
