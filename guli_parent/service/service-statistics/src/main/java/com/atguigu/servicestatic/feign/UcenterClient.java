package com.atguigu.servicestatic.feign;

import com.atguigu.commonutils.commonresult.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/5/2714:01
 * @Company: MGL
 */
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {

    @GetMapping(value = "/serviceucenter/ucenter-member/countregister/{day}")
    public R registerCount(@PathVariable("day") String day);
}