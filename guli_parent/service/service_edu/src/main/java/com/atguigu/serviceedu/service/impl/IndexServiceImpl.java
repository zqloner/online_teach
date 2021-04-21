package com.atguigu.serviceedu.service.impl;

import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.service.EduCourseService;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.atguigu.serviceedu.service.IndexService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/2117:09
 * @Company: MGL
 */
@Service
public class IndexServiceImpl  implements IndexService {
    @Autowired
    private EduCourseService courseService;
    @Autowired
    private EduTeacherService teacherService;

    @Override
    //查询所有banner
    @Cacheable(value = "client",key = "'hostTeacherAndCourse'")
    public Map<String, Object> getClientHotCourseAndTeacher() {
        Map<String, Object> map = new HashMap<>();
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
        map.put("courseList", eduList);
        map.put("teacherList", teacherList);
        return map;
    }
}
