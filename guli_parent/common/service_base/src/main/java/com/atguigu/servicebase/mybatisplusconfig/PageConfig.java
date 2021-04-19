package com.atguigu.servicebase.mybatisplusconfig;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/1516:46
 * @Company: MGL
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.atguigu.serviceedu.mapper") //配置扫描mapper接口
public class PageConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
