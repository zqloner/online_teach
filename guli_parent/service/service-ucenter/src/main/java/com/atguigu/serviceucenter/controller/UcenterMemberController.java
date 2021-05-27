package com.atguigu.serviceucenter.controller;


import com.atguigu.commonutils.commonresult.R;
import com.atguigu.commonutils.jwtutil.JwtUtils;
import com.atguigu.commonutils.ordervo.UcenterMemberOrder;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.serviceucenter.entity.UcenterMember;
import com.atguigu.serviceucenter.entity.vo.LoginVo;
import com.atguigu.serviceucenter.entity.vo.RegisterVo;
import com.atguigu.serviceucenter.service.UcenterMemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-22
 */
@RestController
@RequestMapping("/serviceucenter/ucenter-member")
public class UcenterMemberController {
    @Autowired
    private UcenterMemberService ucenterMemberService;

    @ApiOperation(value = "会员登录")
    @PostMapping("login")
    public R login(@RequestBody LoginVo loginVo) {
        String token = ucenterMemberService.login(loginVo);
        return R.ok().data("token", token);
    }

    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public R register(@RequestBody RegisterVo registerVo){
        ucenterMemberService.register(registerVo);
        return R.ok();
    }

    @ApiOperation(value = "根据token获取登录信息")
    @GetMapping("auth/getLoginInfo")
    public R getLoginInfo(HttpServletRequest request){
        try {
            String memberId = JwtUtils.getMemberIdByJwtToken(request);
            UcenterMember ucenterMember = ucenterMemberService.getById(memberId);
            return R.ok().data("item", ucenterMember);
        }catch (Exception e){
            e.printStackTrace();
            throw new GuliException(20001,"error");
        }
    }

    //根据token字符串获取用户信息
    @ApiOperation(value = "根据token字符串获取用户信息")
    @GetMapping("getInfoUc/{id}")
    public UcenterMemberOrder getInfo(@PathVariable String id) {
        //根据用户id获取用户信息
        UcenterMember ucenterMember = ucenterMemberService.getById(id);
        UcenterMemberOrder ucenterMemberOrder = new UcenterMemberOrder();
        BeanUtils.copyProperties(ucenterMember,ucenterMemberOrder);
        return ucenterMemberOrder;
    }

    //查询某一天注册人数
    @GetMapping(value = "countregister/{day}")
    public R registerCount(
            @PathVariable String day){
        Integer count = ucenterMemberService.countRegisterByDay(day);
        return R.ok().data("countRegister", count);
    }
}

