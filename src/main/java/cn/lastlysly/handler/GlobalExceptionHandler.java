package cn.lastlysly.handler;

import cn.lastlysly.myutils.MyResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-20 17:18
 **/
//@ControllerAdvice 标识这是一个异常处理类
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public MyResult exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e){
        return new MyResult(0,"全局异常处理："+ e.getMessage(),null);

    }
}
