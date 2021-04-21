package com.atguigu.serviceedu.client.impl;

import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.client.VodClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/2015:45
 * @Company: MGL
 */
@Component
public class VodFileDegradeFeignClient implements VodClient {
    @Override
    public R removeVideo(String videoId) {
        return R.error().message("time out");
    }

    @Override
    public R removeVideoList(List<String> videoIdList) {
        return R.error().message("time out");
    }
}
