package top.klw8.alita.validator.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import top.klw8.alita.validator.ThisIsValidator;
import top.klw8.alita.validator.annotations.enums.PasswordStrengthLevel;

/**
 * @ClassName: Password
 * @Description: 用户密码验证器,验证用户的密码是否符合要求
 * 1. 可配制最小密码长度(默认6)
 * 2. 可配制最大密码长度(默认16)
 * 3. TODO 可配制密码类型(只能数字; 只能字母; 混合;)
 * 4. TODO 可配制混合下的复杂度(必须包含字母; 必须包含大写字母; 必须包含特殊符号;)
 * @author klw
 * @date 2019年1月30日 下午6:12:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Inherited  // 子类可以继承父类的注解
@ThisIsValidator
public @interface Password {

    /**
     * @Title: responseStatusCode
     * @Description: 验证失败(不通过)的code
     * @return
     */
    String responseStatusCode() default "500";

    /**
     * @author klw(213539@qq.com)
     * @Description: 最小长度
     */
    int minLength() default 6;

    /**
     * @author klw(213539@qq.com)
     * @Description: 最大长度
     */
    int maxLength() default 16;

    /**
     * @author klw(213539@qq.com)
     * @Description: 密码强度级别,默认 复杂
     */
    PasswordStrengthLevel level() default PasswordStrengthLevel.STRONG;
    
}
