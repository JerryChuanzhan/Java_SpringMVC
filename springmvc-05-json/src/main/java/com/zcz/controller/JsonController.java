package com.zcz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zcz.pojo.User;
import com.zcz.util.JacksonTimeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Description: json测试
 * @ClassName: JsonController
 * @Author: ZCZ
 * @Date 2023年03月19日 17:48
 **/
@RestController
// 所有方法只会返回字符串 相当于 @Controller + @ResponseBody
// 不用再每一个方法都添加 @ResponseBody返回字符串了，前后端分离经常使用的注解
// @Controller
public class JsonController {
    // 通过注解 解决json返回乱码 @RequestMapping(value = "/json",produces = "application/json;charset=utf-8")
    @RequestMapping("/json")
    // @RequestMapping("/json")// 配置文件里，spring解决
    // @ResponseBody // 这个注解添加后，不会走视图解析器，会直接返回一个字符串
    public String Json1() throws JsonProcessingException {
        // jackson ObjectMapper
        ObjectMapper mapper =new ObjectMapper();
        // 创建一个对象
        User user = new User("杰瑞",22,"男");
        String string = mapper.writeValueAsString(user);
        return string;
        // return "test";
    }

    @RequestMapping(value = "/json2",produces = "application/json;charset=utf-8")
    public String json2() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("杰瑞1",22,"男");
        User user2 = new User("杰瑞2",22,"男");
        User user3 = new User("杰瑞3",22,"男");
        User user4 = new User("杰瑞4",22,"男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        // String string = obj.writeValueAsString(users);
        // return string; // 优化 new ObjectMapper().writeValueAsString(users); 合为一步
        return JacksonTimeUtil.getJson(users);// 通过封装工具类返回

    }

    @RequestMapping(value = "/json3",produces = "application/json;charset=utf-8")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        // 1.通过jackson的ObjectMapper配置关闭,然后设置格式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        Date date = new Date();
        // ObjectMapper()  ,时间解析后的默认格式为 ：时间戳 Timestamp 1970.1.1到现在的毫秒数

        // 2.自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ObjectMapper objectMapper = mapper.setDateFormat(sdf);
        String format = sdf.format(date);
        return mapper.writeValueAsString(date);
    }

    @RequestMapping(value = "/json4",produces = "application/json;charset=utf-8")
    public String json4(){
        Date date = new Date();
        String json = JacksonTimeUtil.getJson(date,"yyyy-MM-dd");
        return json;
    }

    // fastjson使用
    @RequestMapping("/json5")
    public String json5(){
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("杰瑞1",22,"男");
        User user2 = new User("杰瑞2",22,"男");
        User user3 = new User("杰瑞3",22,"男");
        User user4 = new User("杰瑞4",22,"男");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(users);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1);

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        String string = JSON.toJSONString(users);
        return string;
    }
}
