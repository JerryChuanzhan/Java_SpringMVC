package com.zcz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 测试用户类
 * @ClassName: User
 * @Author: ZCZ
 * @Date 2023年03月19日 15:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
}
