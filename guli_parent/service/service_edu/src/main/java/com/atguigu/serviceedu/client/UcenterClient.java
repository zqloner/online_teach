package com.atguigu.serviceedu.client;

import com.atguigu.serviceedu.client.impl.UcenterClientImpl;
import com.atguigu.serviceedu.entity.vo.ucentervo.UcenterMemberPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/2910:40
 * @Company: MGL
 */
@Component
@FeignClient(name="service-ucenter",fallback = UcenterClientImpl.class)
public interface UcenterClient {
    //根据用户id获取用户信息
    @GetMapping("/serviceucenter/ucenter-member/getInfoUc/{memberId}")
    public UcenterMemberPay getUcenterPay(@PathVariable("memberId") String memberId);
}
