package cn.lastlysly.controller;

import cn.lastlysly.myutils.MyResult;
import cn.lastlysly.pojo.AccountSheet;
import cn.lastlysly.pojo.UserinfoSheet;
import cn.lastlysly.service.UserinfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-07-31 15:41
 **/
@Controller
public class UserShiroDemoController {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserinfoService userinfoService;

    /**
     * 分离式测试，登陆
     * @param userName
     * @param passWord
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/fenlilogin" , method = RequestMethod.POST)
    @ResponseBody
    public MyResult login(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord);
        try {
            subject.login(token);
            String sessionId = (String) subject.getSession().getId();
            return new MyResult(1,"登陆成功",sessionId);
        } catch (AuthenticationException e) {
            return new MyResult(0,"登陆失败,用户名或密码错误",null);
        }
    }

    /**
     * 分离式测试，主数据
     * @return
     */
    @CrossOrigin
    @RequestMapping("/fenlimain")
    @ResponseBody
    public MyResult getAccountInfo(){

        List<AccountSheet> list = userinfoService.selectAccountInfo();
        MyResult sucessResponseJson = new MyResult(1,"查询成功",list);
//        int a = 1 / 0;
        return sucessResponseJson;

    }




    /**
     * shiro入门
     * @param userSheet
     * @param request
     * @return
     */
    @RequestMapping(value = "/subLogin" ,method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public String subLogin(UserinfoSheet userSheet, HttpServletRequest request){
//        String username = request.getParameter("userLoginId");
//        String password = request.getParameter("userPassword");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userSheet.getUserLoginId(),userSheet.getUserPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        if (subject.hasRole("admin")){

            if (subject.isPermitted("user:delete")){
                logger.info("登陆成功，是admin角色,有user:delete权限{}",1111);
                return "登陆成功，是admin角色,有user:delete权限";
            }
            return "登陆成功，是admin角色,没有user:delete权限";

        }else{
            return "登陆成功,不是admin角色";
        }

    }

    /**
     * ajax操作
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/ajaxlogin",method = RequestMethod.POST)
    @ResponseBody
    public String ajaxlogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("{}=={}",username , password);
        return username + "==" + password;
    }

    /**
     * 注解授权demo
     * @return
     */
    @RequiresRoles("admin")
    @RequestMapping(value = "/testRole",method = RequestMethod.GET)
    @ResponseBody
    public String testRole(){
        return "testRole测试，，注解授权，@RequiresRoles(\"admin\")，有指定角色的用户方可访问";
    }

    /**
     * 注解授权demo
     * @return
     */
    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/testPermission",method = RequestMethod.GET)
    @ResponseBody
    public String testPermission(){
        return "testPermission测试，，注解授权，@RequiresPermissions(\"user:delete\")有指定权限的用户方可访问";
    }


}
