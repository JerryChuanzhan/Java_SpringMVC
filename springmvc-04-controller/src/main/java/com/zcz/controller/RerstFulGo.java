package com.zcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 转发和重定向
 * @ClassName: RerstFulGo
 * @Author: ZCZ
 * @Date 2023年03月19日 15:00
 **/
@Controller
public class RerstFulGo {

    @GetMapping("r/r1")
    public String test1(Model model){
        model.addAttribute("msg","实现转发！");
        return "test";// 不注释视图解析器，拼接前缀、后缀
    }
    @RequestMapping("r/r2")
    public String test2(Model model){
        model.addAttribute("msg","手动拼接视图路径，实现转发！");
        return "/WEB-INF/jsp/test.jsp";// 注释视图解析器，手动拼接视图路径
       // return "/WEB-INF/jsp/test.jspp";
    }

    @GetMapping("r/r3")
    public String test3(Model model){
        model.addAttribute("msg","实现重定向！");
        return "redirect:/index.jsp";// 重定向不受视图解析器页面路径拼接影响,本质是请求到一个新路径，不访问/WEB-INF下的资源
        // 可以重定向到新请求实现
        //return "redirect:hello.do"; //hello.do为另一个请求/
    }
}
