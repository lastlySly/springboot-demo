package cn.lastlysly.myutils.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Enumeration;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-07-31 18:00
 **/
//重写DefaultWebSessionManager获取sessionId的方法
public class MySessionManager extends DefaultWebSessionManager {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
//        String token = httpServletRequest.getHeader("token");

        // 拿到所有请求头
        Enumeration e1 = httpServletRequest.getHeaderNames();
        while (e1.hasMoreElements()) {
            String headerName = (String) e1.nextElement();
            String headValue = httpServletRequest.getHeader(headerName);
            logger.info("遍历输出拿到的所有请求头{}====={}",headerName,headValue);
        }

        String token = httpServletRequest.getParameter("token");
        logger.info("这里是token：{}",token);
        if(!StringUtils.isEmpty(token)){
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "token");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return token;

        }else{
            return super.getSessionId(request, response);
        }

    }
}