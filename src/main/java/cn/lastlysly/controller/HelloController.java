package cn.lastlysly.controller;

import cn.lastlysly.myutils.MyResult;
import cn.lastlysly.myutils.taskdemo.TestTask;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-20 15:36
 * 这个是拦截器和测试json输出的demo
 **/
@RestController
@RequestMapping("/interceptor")
public class HelloController {

//    @GetMapping("/hello")
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        String str = "Hello SpringBoot，测试拦截器，" +
                "用PostMan模拟AJax请求访问显示不同效果,注意，" +
                "（该例中我没有定义消息转换器，如果定义了消息转换器会导致@ResposeBody不可用，限于" +
                "直接继承WebMvcConfigurationSupport，直接实现接口WebMvcConfigurer尚未测试）";

        return str;
    }
//
    @RequestMapping("/myjson")
    public MyResult testJson(){
        return new MyResult(1,"测试json",null);
    }

}
