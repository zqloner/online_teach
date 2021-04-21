package com.atguigu.serviceedu.controller.client;

import com.atguigu.commonutils.R;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduCourseService;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:  前台展示课程和讲师列表
 * @Author: zhangqi
 * @CreateTime: 2021/4/2114:08
 * @Company: MGL
 */
@RestController
@RequestMapping("/serviceedu/index")
public class IndexController {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;

    //查询前8条热门课程，查询前4条名师
    @GetMapping("index")
    public R index() {
        //查询前8条热门课程
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        wrapper.last("limit 8");
        List<EduCourse> eduList = courseService.list(wrapper);

        //查询前4条名师
        QueryWrapper<EduTeacher> wrapperTeacher = new QueryWrapper<>();
        wrapperTeacher.orderByDesc("id");
        wrapperTeacher.last("limit 4");
        List<EduTeacher> teacherList = teacherService.list(wrapperTeacher);

        return R.ok().data("eduList",eduList).data("teacherList",teacherList);
    }
}
