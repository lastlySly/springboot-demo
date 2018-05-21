package cn.lastlysly.interceptor;

import cn.lastlysly.myutils.MyUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-20 15:42
 **/

public class MyInterceptorOne implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //解决中文乱码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("在请求处理之前进行调用（Controller方法调用之前）");
        Map<String,Object> map = new HashMap<String,Object>();
        ObjectMapper om = new ObjectMapper();


        if(MyUtils.isAjax(request)){
            System.out.println("这是Ajax请求====");
            System.out.println("222222");
            String str = request.getParameter("iid");
            System.out.println("222222"+str);
            if (!str.equals("sly")){
                PrintWriter out = response.getWriter();
                map.put("code",0);
                map.put("tip","这是测试拦截器拦截ajax请求并返回json数据供前端跳转，已经拦截");
                String myStr = om.writeValueAsString(map);

                out.print(myStr);
                out.flush();
                return false;
            }
            System.out.println("=====已通过");
//            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理之后调用，但在视图被渲染之前调用（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("在整个请求结束后调用，主要用于资源清理工作");
    }
}
