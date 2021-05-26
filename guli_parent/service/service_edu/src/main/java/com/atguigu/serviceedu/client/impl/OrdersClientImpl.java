package com.atguigu.serviceedu.client.impl;

import com.atguigu.serviceedu.client.OrdersClient;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/5/2613:52
 * @Company: MGL
 */
@Component
public class OrdersClientImpl implements OrdersClient {
    @Override
    public boolean isBuyCourse(String memberid, String id) {
        return false;
    }
}
