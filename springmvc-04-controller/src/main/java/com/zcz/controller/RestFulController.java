package com.zcz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: RestFul风格请求方式
 * @ClassName: RestFulController
 * @Author: ZCZ
 * @Date 2023年03月19日 13:54
 **/
@Controller
public class RestFulController {

    //原来风格 ：  http://localhost:8080/add?a=1&b=2
    //RestFul风格 : http://localhost:8080/add/a/b

    // @PathVariable 路径变量 注解，可以让参数的值绑定到url上的模板变量上
    // @RequestMapping("/add/{a}/{b}")
    // @RequestMapping(value = "/add/{a}/{b}",method = {RequestMethod.GET})

    // 映射访问路径
    @RequestMapping(value = "/add/{a}/{b}",method = {RequestMethod.GET})
    // @GetMapping("/add/{a}/{b}")
    // @GetMapping 等价  @RequestMapping(method =RequestMethod.GET)
    public String test1(@PathVariable int a, @PathVariable int b , Model model){
        int result =a +b;
        // springmvc实例一个model对象，向视图传值
        model.addAttribute("msg","结果为："+result);
        // 返回视图的位置
        return "test";
    }
}
