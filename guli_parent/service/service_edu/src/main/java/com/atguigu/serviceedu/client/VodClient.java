package com.atguigu.serviceedu.client;

import com.atguigu.commonutils.commonresult.R;
import com.atguigu.serviceedu.client.impl.VodFileDegradeFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/209:35
 * @Company: MGL
 */
@FeignClient(name="service-vod",fallback = VodFileDegradeFeignClient.class )
@Component
public interface VodClient {
    @DeleteMapping(value = "/servicevod/video/{videoId}")
    public R removeVideo(@PathVariable("videoId") String videoId);

    @DeleteMapping(value = "/servicevod/video/delete-batch")
    public R removeVideoList(@RequestParam("videoIdList") List<String> videoIdList);
}
