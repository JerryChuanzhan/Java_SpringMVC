package com.zcz.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @Description: json返回时间格式工具类
 * @ClassName: JacksonTimeDiy
 * @Author: ZCZ
 * @Date 2023年03月19日 19:16
 **/
public class JacksonTimeUtil {
    // 封装思想
    public static String getJson(Object object) {
        // 不传日期格式，默认返回的时间格式
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    // 传参时间对象、自定义时间返回格式
    public static String getJson(Object object,String dateFormat) {
        ObjectMapper mapper = new ObjectMapper();
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //指定日期格式
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
