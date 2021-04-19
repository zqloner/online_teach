package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/148:44
 * @Company: MGL
 */
public interface FileService {
    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file,String pathDir);
}
