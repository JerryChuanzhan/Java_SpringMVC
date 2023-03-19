package com.zcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 注解实现spring MVC
 * @ClassName: Herllocontroller
 * @Author: ZCZ
 * @Date 2023年03月17日 0:12
 **/
@Controller
public class Herllocontroller {

    @RequestMapping("/hello")
    public String hello(Model model){
        // 封装数据
        model.addAttribute("msg","这是通过注解实现的springmvc");
        return "hello";// 会被视图解析器处理，拼接前缀、后缀，找到对应页面
    }
}
