package com.atguigu.servicestatic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/5/2713:51
 * @Company: MGL
 */
@ComponentScan(basePackages = {"com.atguigu"})
@SpringBootApplication//取消数据源自动配置
@MapperScan("com.atguigu.servicestatic.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class StaticApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaticApplication.class, args);
    }
}
