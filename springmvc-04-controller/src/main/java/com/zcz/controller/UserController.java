package com.zcz.controller;

import com.zcz.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 测试用户控制器
 * @ClassName: UserController
 * @Author: ZCZ
 * @Date 2023年03月19日 15:30
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/u1")
    // 提交的域名称和处理方法的参数名不一致
    // 方法 @RequestParam("username") : username提交的域的名称
    public String user(@RequestParam("username") String name, @RequestParam("age") int age ,Model model){
        System.out.println(name);
        model.addAttribute("msg","用户名字为:"+name+" 用户年龄为:"+age);
        return "test";
    }

    @GetMapping("/u2/{name}/{age}")
    public String user2(@PathVariable String name, @PathVariable int age , Model model){
        // 1.接收前端参数
        System.out.println(name);
        // 2.将返回结果传递给前端 model
        model.addAttribute("msg","用户名字为:"+name+" 用户年龄为:"+age);
        // 3.视图跳转
        return "test";
    }

    // 前端接收一个对象 : id,name,age
    /*
    1. 接收前端用户传来的参数，判定参数的名字，假设名字直接在方法上，可以直接使用
    2. 前端传递的是一个对象User，匹配User对象中的字段名，如果名称一致则🆗，否则匹配不到
    例如user对象名字属性为name，前端传递username值，接收值name就匹配不到，为nll
    如果使用对象的话，前端传递的参数名和对象名必须一致，否则就是null。
     */
    @GetMapping("/u3")
    public String user3(User user){
        System.out.println(user);
        return "test";
    }
}
