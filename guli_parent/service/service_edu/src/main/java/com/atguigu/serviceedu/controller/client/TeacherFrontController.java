package com.atguigu.serviceedu.controller.client;

import com.atguigu.commonutils.commonresult.R;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/2616:53
 * @Company: MGL
 */
@RestController
@RequestMapping("/serviceedu/teacherfront")
public class TeacherFrontController {
    @Resource
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "分页讲师列表")
    @GetMapping(value = "getTeacherFrontList/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit){

        Page<EduTeacher> pageParam = new Page<EduTeacher>(page, limit);

        Map<String, Object> map = eduTeacherService.pageListWeb(pageParam);

        return  R.ok().data(map);
    }
}
