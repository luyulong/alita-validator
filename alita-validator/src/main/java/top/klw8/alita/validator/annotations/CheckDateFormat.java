package top.klw8.alita.validator.annotations;

import org.springframework.core.annotation.AliasFor;
import top.klw8.alita.validator.ThisIsValidator;

import java.lang.annotation.*;

/**
 * @author klw(213539 @ qq.com)
 * @ClassName: CheckDateFormat
 * @Description: 日期格式验证器, 检查日期字符串是否为指定格式
 * @date 2020/1/7 11:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Inherited  // 子类可以继承父类的注解
@ThisIsValidator
public @interface CheckDateFormat {

    @AliasFor("validatFailMessage")
    String value() default "日期格式不正确";

    /**
     * @author klw(213539@qq.com)
     * @Description: 日期格式
     */
    String format() default "yyyy-MM-dd HH:mm:ss";

    /**
     * @Title: responseStatusCode
     * @Description: 验证失败(不通过)的code
     * @return
     */
    String responseStatusCode() default "500";

    /**
     * @Title: validatFailMessage
     * @Description: 验证失败(不通过)的文字消息,可为空,默认使用ResponseStatusCodeEnum对应的消息
     * @return
     */
    @AliasFor("value")
    String validatFailMessage() default "日期格式不正确";

}
