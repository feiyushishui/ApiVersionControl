package mytest.versioncontrol.demo2.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @Description
 * @author wangheng
 * @date 2019/4/1
 * @return
 */
@SpringBootConfiguration
public class WebMvcRegistrationsConfig implements WebMvcRegistrations {
    /**
     * @Description 重写请求过处理的方法
     * @author wangheng
     * @date 2019/4/1
     * @param
     * @return org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
     */
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new CustomRequestMappingHandlerMapping();
    }
}
