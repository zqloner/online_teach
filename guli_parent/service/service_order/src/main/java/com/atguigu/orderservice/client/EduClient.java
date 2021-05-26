package com.atguigu.orderservice.client;

import com.atguigu.commonutils.ordervo.CourseOrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/5/2413:34
 * @Company: MGL
 */
@Component
@FeignClient("service-edu")
public interface EduClient {
    //根据课程id查询课程信息
    @GetMapping("/serviceedu/coursefront/getDto/{courseId}")
    public CourseOrderInfo getCourseInfoDto(@PathVariable("courseId") String courseId);
}