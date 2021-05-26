package com.atguigu.serviceedu.controller.client;

import com.atguigu.commonutils.commonresult.R;
import com.atguigu.commonutils.jwtutil.JwtUtils;
import com.atguigu.commonutils.ordervo.CourseOrderInfo;
import com.atguigu.serviceedu.client.OrdersClient;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.vo.chapter.ChapterVo;
import com.atguigu.serviceedu.entity.vo.front.CourseQueryVo;
import com.atguigu.serviceedu.entity.vo.front.CourseWebVo;
import com.atguigu.serviceedu.service.EduChapterService;
import com.atguigu.serviceedu.service.EduCourseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
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

    @Autowired
    private EduChapterService eduChapterService;

    @Resource
    private OrdersClient ordersClient;

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

    @ApiOperation(value = "根据ID查询课程")
    @GetMapping(value = "{courseId}")
    public R getById(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
            @PathVariable String courseId,
            HttpServletRequest request){

        //查询课程信息和讲师信息
        CourseWebVo courseWebVo = eduCourseService.selectInfoWebById(courseId);

        //查询当前课程的章节信息
        List<ChapterVo> chapterVoList = eduChapterService.nestedList(courseId);

        //根据课程id和用户id查询当前课程是否已经支付过了
        //todo  如果这里没有用户登录。我们可以跳转到登录页面
        if (JwtUtils.getMemberIdByJwtToken(request) == null) {
            return R.ok().code(28004).message("请先登录");
        }
        boolean buyCourse = ordersClient.isBuyCourse(courseId, JwtUtils.getMemberIdByJwtToken(request));

        return R.ok().data("course", courseWebVo).data("chapterVoList", chapterVoList).data("isBuy",buyCourse);
    }
}
