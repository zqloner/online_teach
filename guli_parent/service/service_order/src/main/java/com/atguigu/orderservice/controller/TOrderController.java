package com.atguigu.orderservice.controller;


import com.atguigu.commonutils.commonresult.R;
import com.atguigu.commonutils.jwtutil.JwtUtils;
import com.atguigu.orderservice.entity.TOrder;
import com.atguigu.orderservice.service.TOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author zhangqi
 * @since 2021-05-24
 */
@RestController
@RequestMapping("/orderservice/order")
public class TOrderController {

    @Autowired
    private TOrderService tOrderService;

    //根据课程id和用户id创建订单，返回订单id
    @PostMapping("createOrder/{courseId}")
    public R save(@PathVariable String courseId, HttpServletRequest request) {
        String orderId = tOrderService.saveOrder(courseId, JwtUtils.getMemberIdByJwtToken(request));
        return R.ok().data("orderId", orderId);
    }


    @GetMapping("getOrder/{orderId}")
    public R get(@PathVariable String orderId) {
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no",orderId);
        TOrder order = tOrderService.getOne(wrapper);
        return R.ok().data("item", order);
    }

    /*
    根据用户id和课程id查询订单信息
     */
    @GetMapping("isBuyCourse/{memberid}/{id}")
    public boolean isBuyCourse(@PathVariable("memberid") String memberid,
                               @PathVariable("id") String id) {
        //订单状态是1表示支付成功
        int count = tOrderService.count(new QueryWrapper<TOrder>().
                eq("member_id", memberid).
                eq("course_id", id).
                eq("status", 1));
        if(count>0) {
            return true;
        } else {
            return false;
        }
    }
}

