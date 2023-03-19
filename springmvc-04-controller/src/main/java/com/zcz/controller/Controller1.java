package com.zcz.controller;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 通过controller接口实现
 * @ClassName: Controller1
 * @Author: ZCZ
 * @Date 2023年03月17日 0:43
 **/
public class Controller1 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","通过重写controller接口实现的springmvc");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
