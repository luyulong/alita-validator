package top.klw8.alita.validator.custom.custom2;

import top.klw8.alita.validator.IAnnotationsValidator;
import top.klw8.alita.validator.ValidatorException;
import top.klw8.alita.validator.ValidatorImpl;

import java.lang.annotation.Annotation;

/**
 * @author klw
 * @ClassName: Custom2Impl
 * @Description: 测试自定义验证器实现2
 * @date 2019/6/13 17:18
 */
@ValidatorImpl(validator = {Custom2.class})
public class Custom2Impl implements IAnnotationsValidator {
    @Override
    public void doValidator(Object object, Annotation annotation) throws ValidatorException {
        System.out.println("====================自定义2执行了");
    }
}
