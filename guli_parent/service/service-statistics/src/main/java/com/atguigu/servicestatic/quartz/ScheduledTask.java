package com.atguigu.servicestatic.quartz;

import com.atguigu.servicestatic.service.StatisticsDailyService;
import com.atguigu.servicestatic.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description:
 * @Author: zhangqi
 * @CreateTime: 2021/5/2716:42
 * @Company: MGL
 */
@Component
public class ScheduledTask {

    @Autowired
    private StatisticsDailyService dailyService;

    /**
     * 测试
     * 每天七点到二十三点每五秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() {
        System.out.println("*********++++++++++++*****执行了");
    }

    /**
     * 每天凌晨1点执行定时，把前一天数据查询进行添加
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        //获取上一天的日期
        String day = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        dailyService.createStatisticsByDay(day);

    }
}