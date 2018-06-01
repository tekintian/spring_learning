package cn.tekin.spring.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class HelloController{
    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping("p1")
    public String p1(ModelMap modelMap){
        modelMap.addAttribute("msgtest","This is the Ptest打印测试方法");

        return "ptest";
    }
}