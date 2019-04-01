package mytest.versioncontrol.demo2.configuration;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @Description 接口版本标识注解
 * @author wangheng
 * @date 2019/4/1
 * @param
 * @return
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    int value() default 1;
}
