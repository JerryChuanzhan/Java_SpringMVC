package com.zcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 通过注解实现controller
 * @ClassName: Controller2
 * @Author: ZCZ
 * @Date 2023年03月17日 0:53
 **/
@Controller // 代表这个类会被spring接管
// 被这个注解的类中的所有方法，如果返回值是String，并且有具体页面可以跳转 ，那么就会被视图解析器解析；
public class Controller2 {
    @RequestMapping("/annonation")
    public String hello(Model model){
        model.addAttribute("msg","通过注解实现的controller");
        return "test";
    }
}
