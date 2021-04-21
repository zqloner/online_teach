package com.atguigu.serviceedu.controller.client;

import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.service.IndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:  前台展示课程和讲师列表
 * @Author: zhangqi
 * @CreateTime: 2021/4/2114:08
 * @Company: MGL
 */
@RestController
@RequestMapping("/serviceedu/client")
public class IndexController {
    @Resource
    private IndexService indexService;

    //查询前8条热门课程，查询前4条名师
    @GetMapping("index")
    public R index() {
        return R.ok().data("courseList",indexService.getClientHotCourse()).data("teacherList", indexService.getClientHotTeacher());
    }
}
