package com.atguigu.serviceucenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/229:21
 * @Company: MGL
 */
@ComponentScan(basePackages = {"com.atguigu"})
@SpringBootApplication//取消数据源自动配置
@MapperScan("com.atguigu.serviceucenter.mapper")
public class UcenterApplication{
    public static void main(String[] args) {
        SpringApplication.run(UcenterApplication.class, args);
    }
}