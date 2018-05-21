package cn.lastlysly;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.charset.Charset;


/**
 * @ComponentScan告诉Spring 哪个packages 的用注解标识的类 会被spring自动扫描并且装入bean容器。
 * @ComponentScan(basePackages = {"cn.lastlysly.myutils","cn.lastlysly.myutils.taskdemo"})
 * 扫描所有需要的包，包含一些自用的工具类包 所在的路径
 * 一旦定义了@ComponentScan，那么该启动类将只扫描指定的几个包下的。默认是启动类当前包下
 */
@EnableScheduling //开启定时任务
@ComponentScan(basePackages = {"cn.lastlysly","cn.lastlysly.myutils.taskdemo"})
@SpringBootApplication
public class SpringbootDemoApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringbootDemoApplication.class);
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootDemoApplication.class, args);
		SpringApplication springApplication = new SpringApplication(SpringbootDemoApplication.class);
//		springApplication.setBannerMode(Banner.Mode.OFF);//关闭banner
		springApplication.run(args);
	}



	//消息转换器
//    @Bean
//    public StringHttpMessageConverter stringHttpMessageConverter() {
//        //ISO-8859-1
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("utf-8"));
//        return converter;
//    }
}
