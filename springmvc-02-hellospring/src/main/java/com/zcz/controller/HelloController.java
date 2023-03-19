package com.zcz.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 配置文件实现springmvc
 * @ClassName: HelloController
 * @Author: ZCZ
 * @Date 2023年03月16日 23:42
 **/
public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        // 业务代码
        String result = "Hello,这是执行业务返回的数据";
        mv.addObject("msg",result);
        // 视图跳转
        mv.setViewName("test");
        return mv;
    }

}
