package com.atguigu.servicemsm.service;

import java.util.Map;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/21--->22:37
 * @Company: MGL
 */
public interface MsmService {
    public boolean send(String PhoneNumbers, String templateCode, Map<String, Object> param);
}
