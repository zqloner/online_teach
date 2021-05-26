package com.atguigu.serviceedu.client;

import com.atguigu.serviceedu.client.impl.OrdersClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/5/2613:47
 * @Company: MGL
 */
@Component
@FeignClient(name="service-order",fallback = OrdersClientImpl.class)
public interface OrdersClient {
    /*
根据用户id和课程id查询订单信息
 */
    @GetMapping("isBuyCourse/{memberid}/{id}")
    public boolean isBuyCourse(@PathVariable("memberid") String memberid,
                               @PathVariable("id") String id);
}
