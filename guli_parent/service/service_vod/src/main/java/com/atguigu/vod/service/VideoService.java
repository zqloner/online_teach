package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/1910:53
 * @Company: MGL
 */
public interface VideoService {
    String uploadVideo(MultipartFile file);
    void removeVideo(String videoId);
    void removeVideoList(List<String> videoIdList);
}
