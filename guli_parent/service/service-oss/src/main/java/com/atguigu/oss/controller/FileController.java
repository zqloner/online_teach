package com.atguigu.oss.controller;

import com.atguigu.commonutils.commonresult.R;
import com.atguigu.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/149:01
 * @Company: MGL
 */
@Api(description="阿里云文件管理")
@RestController
@RequestMapping("/serviceoss/file")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 文件上传
     *
     * @param file
     */
    @ApiOperation(value = "文件上传")
    @PostMapping("upload")
    public R upload(
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam("file") MultipartFile file,

            @ApiParam(name = "pathDir", value = "文件上传路径,如 path/bashDir")
            @RequestParam("pathDir") String pathDir) {

        String uploadUrl = fileService.upload(file,pathDir);
        //返回r对象
        return R.ok().message("文件上传成功").data("url", uploadUrl);

    }

}
