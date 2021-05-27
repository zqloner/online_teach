package com.atguigu.servicestatic.controller;


import com.atguigu.commonutils.commonresult.R;
import com.atguigu.servicestatic.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author zhangqi
 * @since 2021-05-27
 */
@RestController
@RequestMapping("/servicestatic/statistics-daily")
public class StatisticsDailyController {
    @Autowired
    private StatisticsDailyService statisticsDailyService;

    @PostMapping("{day}")
    public R createStatisticsByDate(@PathVariable String day) {
        statisticsDailyService.createStatisticsByDay(day);
        return R.ok();
    }
}

