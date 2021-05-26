package com.atguigu.orderservice.controller;


import com.atguigu.commonutils.commonresult.R;
import com.atguigu.orderservice.service.TPayLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author zhangqi
 * @since 2021-05-24
 */
@Slf4j
@RestController
@RequestMapping("/orderservice/paylog")
public class TPayLogController {
    @Autowired
    private TPayLogService payLogService;

    /**
     * 生成二维码
     *
     * @return
     */
    @GetMapping("/createNative/{orderNo}")
    public R createNative(@PathVariable String orderNo) {
        //返回信息,包含二维码地址,还有其他信息。
        Map map = payLogService.createNative(orderNo);
        log.info("生成二维码返回的信息:{}",map);
        return R.ok().data(map);
    }

    /*
    查询支付状态
     */
    @GetMapping("/queryPayStatus/{orderNo}")
    public R queryPayStatus(@PathVariable String orderNo) {
        //调用查询接口
        Map<String, String> map = payLogService.queryPayStatus(orderNo);
        if (map == null) {//出错
            return R.error().message("支付出错");
        }
        if (map.get("trade_state").equals("SUCCESS")) {//如果成功
            //更改订单状态
            log.info("查询支付状态返回的信息:{}",map);
            payLogService.updateOrderStatus(map);
            return R.ok().message("支付成功");
        }

        return R.ok().code(25000).message("支付中");
    }

}

