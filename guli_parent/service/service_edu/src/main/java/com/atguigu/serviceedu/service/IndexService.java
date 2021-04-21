package com.atguigu.serviceedu.service;

import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;

import java.util.List;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/2117:08
 * @Company: MGL
 */
public interface IndexService {
    public List<EduCourse> getClientHotCourse();
    public List<EduTeacher> getClientHotTeacher();
}
