package com.atguigu.servicestatic.controller;


import com.atguigu.commonutils.commonresult.R;
import com.atguigu.servicestatic.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    /*
    图标显示,返回两部分数据,日期json数组,数量json数组
     */
    @GetMapping("show-chart/{begin}/{end}/{type}")
    public R showChart(@PathVariable String begin,@PathVariable String end,@PathVariable String type){
        Map<String, Object> map = statisticsDailyService.getChartData(begin, end, type);
        return R.ok().data(map);
    }
}

