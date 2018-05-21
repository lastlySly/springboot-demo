package cn.lastlysly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2018-05-21 16:03
 * 这是整合Thymeleaf模板引擎的demo
 **/
@Controller
@RequestMapping("/th")
public class ThylemeafDemoController {
    @RequestMapping("/index")
    public String index(ModelMap modelMap){
        modelMap.addAttribute("name","动态thymeleaf,注意使用thymeleaf时，" +
                "Controller类不能使用@RestController,要用@Controller");
        return "mythymeleaftest";
    }
}
