package com.zcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 乱码问题
 * @ClassName: EndodingController
 * @Author: ZCZ
 * @Date 2023年03月19日 16:19
 **/
@Controller
public class EndodingController {
    // 过滤器解决乱码
    @PostMapping("encoding/e1")
    public String encoding(@RequestParam("name") String name , Model model){
        System.out.println(name);
        model.addAttribute("msg","输入显示："+name);
        return "test";
    }
}
