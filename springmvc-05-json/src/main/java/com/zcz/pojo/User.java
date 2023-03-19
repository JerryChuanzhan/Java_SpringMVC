package com.zcz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 测试User实体类
 * @ClassName: User
 * @Author: ZCZ
 * @Date 2023年03月19日 17:46
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private int age;
    private String sex;
}
