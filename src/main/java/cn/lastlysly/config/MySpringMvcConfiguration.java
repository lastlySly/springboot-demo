package cn.lastlysly.config;

import cn.lastlysly.interceptor.MyInterceptorOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-20 15:40
 **/

//WebMvcConfigurerAdapter在spring5.0已经被废弃
//解决方法为：
/*
 * 1，直接实现接口WebMvcConfigurer
 * 2，直接继承WebMvcConfigurationSupport
 * 官方推荐第一种，，第二种会导致MVC的自动配置失效
 * */
@Configuration
public class MySpringMvcConfiguration implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<String>();
        //patterns.add("/*/**");
        patterns.add("/interceptor/**");
        registry.addInterceptor(new MyInterceptorOne()).addPathPatterns(patterns);
    }

}


//@Configuration
//public class MySpringMvcConfiguration extends WebMvcConfigurationSupport {
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        List<String> patterns = new ArrayList<String>();
////        patterns.add("/*/**");
//        patterns.add("/interceptor/**");
//        registry.addInterceptor(new MyInterceptorOne()).addPathPatterns(patterns);
//    }
//
////    @Override
////    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
////        super.configureMessageConverters(converters);
////        //ISO-8859-1
////        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("utf-8"));
////        converters.add(converter);
////    }
//}

