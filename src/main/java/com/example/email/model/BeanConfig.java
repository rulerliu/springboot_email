package com.example.email.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional({WindowsCondition.class, ObstinateCondition.class})
public class BeanConfig {

    //只有一个类时，大括号可以省略
    //如果WindowsCondition的实现方法返回true，则注入这个bean
//    @Conditional({WindowsCondition.class})
    @Bean(name = "wzry")
    public User person1(){
        return new User(1L, "王者荣耀");
    }

    //如果LinuxCondition的实现方法返回true，则注入这个bean
//    @Conditional({LinuxCondition.class})
    @Bean("cj")
    public User person2(){
        return new User(2L, "吃鸡");
    }
}