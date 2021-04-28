package com.atguigu.serviceedu.controller;


import com.atguigu.commonutils.commonresult.R;
import com.atguigu.serviceedu.entity.EduCourse;
import com.atguigu.serviceedu.entity.EduTeacher;
import com.atguigu.serviceedu.entity.vo.TeacherQuery;
import com.atguigu.serviceedu.service.EduCourseService;
import com.atguigu.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-08
 */
@Api(value = "讲师管理")
@RestController
@RequestMapping("/serviceedu/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    @Autowired
    private EduCourseService eduCourseService;

    /*
    1，查询所有讲师方法
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public R list(){
        List<EduTeacher> list = teacherService.list(null);
        return R.ok().data("items", list);
    }

    /*
    2，删除讲师逻辑
     */
    @DeleteMapping("deleteTeacher/{id}")
    @ApiOperation(value = "逻辑删除讲师")
    public R removeById(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /*
    3，分页查询讲师的方法
    //current 代表当前页
    // limit 代表每页记录数
     */
    @ApiOperation(value = "基本分页讲师列表")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current,@PathVariable long limit) {
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        //调用方法实现分页
        IPage<EduTeacher> page = teacherService.page(pageTeacher, null);
        //总记录数
        long total = page.getTotal();
        //每页数据的list集合
        List<EduTeacher> records = page.getRecords();
        return R.ok().data("total", total).data("rows", records);
    }


    /*
    4，多条件分页查询
     */
    @ApiOperation(value = "多条件分页讲师列表")
    @PostMapping("pageTeacherCondition/{page}/{limit}")
    public R getTeacherListPage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            @RequestBody(required = false)
            TeacherQuery teacherQuery){

        Page<EduTeacher> pageParam = new Page<>(page, limit);

        teacherService.pageQuery(pageParam, teacherQuery);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return  R.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "新增讲师")
    @PostMapping("addTeacher")
    public R save(
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher eduTeacher) {
        boolean save = teacherService.save(eduTeacher);
        if (save) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("getTeacher/{id}")
    public R getById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id){

        EduTeacher eduTeacher = teacherService.getById(id);
        //根据讲师id查询这个讲师的课程列表
        List<EduCourse> courseList = eduCourseService.selectByTeacherId(id);

        return R.ok().data("item", eduTeacher).data("courseList", courseList);
    }

    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("updateTeacher/{id}")
    public R updateById(
            @ApiParam(name = "id", value = "讲师ID", required = true)
            @PathVariable String id,

            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody EduTeacher eduTeacher){

        eduTeacher.setId(id);
        teacherService.updateById(eduTeacher);
        return R.ok();
    }

}

