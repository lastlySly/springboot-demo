package cn.lastlysly.controller;

import cn.lastlysly.handler.MyCustomException;
import cn.lastlysly.myutils.MyResult;
import cn.lastlysly.pojo.AccountSheet;
import cn.lastlysly.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-07-31 15:18
 **/
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/getaccountinfo")
    @ResponseBody
    public MyResult getAccountInfo(){

        List<AccountSheet> list = userinfoService.selectAccountInfo();
        MyResult sucessResponseJson = new MyResult(1,"查询成功",list);
//        int a = 1 / 0;
        return sucessResponseJson;

    }
    //    @ResponseBody可以不写
    @RequestMapping("/transfer")
    public MyResult transferAccount(HttpServletRequest request, HttpServletResponse response) throws MyCustomException {
        int inId = Integer.parseInt(request.getParameter("accountIn"));
        int outId = Integer.parseInt(request.getParameter("accountOut"));
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            if (userinfoService.updateTransferAccount(money,outId,inId)){
                return new MyResult(1,"转账成功",null);
            }
        }catch (Exception e){
            throw new MyCustomException("转账接口异常：" + e.getMessage());
        }

        return new MyResult(0,"转账失败",null);

    }



}
