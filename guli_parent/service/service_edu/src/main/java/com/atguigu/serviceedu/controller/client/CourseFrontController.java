package com.atguigu.serviceedu.controller.client;

import com.atguigu.commonutils.commonresult.R;
import com.atguigu.commonutils.ordervo.CourseOrderInfo;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.vo.front.CourseQueryVo;
import com.atguigu.serviceedu.entity.vo.front.CourseWebVo;
import com.atguigu.serviceedu.service.EduCourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/4/2616:53
 * @Company: MGL
 */
@RestController
@RequestMapping("/serviceedu/coursefront")
public class CourseFrontController {
    @Resource
    private EduCourseService eduCourseService;

    @ApiOperation(value = "分页课程列表")
    @PostMapping(value = "/getFrontCourseList/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "courseQuery", value = "查询对象", required = false)
            @RequestBody(required = false) CourseQueryVo courseQuery){
        Page<EduCourse> pageParam = new Page<EduCourse>(page, limit);
        Map<String, Object> map = eduCourseService.pageListWeb(pageParam, courseQuery);
        return  R.ok().data(map);
    }


    //根据课程id查询课程信息
    @GetMapping("getDto/{courseId}")
    public CourseOrderInfo getCourseInfoDto(@PathVariable String courseId) {
        CourseWebVo courseWebVo = eduCourseService.selectInfoWebById(courseId);
        CourseOrderInfo courseOrderInfo = new CourseOrderInfo();
        BeanUtils.copyProperties(courseWebVo,courseOrderInfo);
        return courseOrderInfo;
    }
}
