package com.atguigu.servicecms.controller;

import com.atguigu.commonutils.R;
import com.atguigu.servicecms.entity.CrmBanner;
import com.atguigu.servicecms.service.CrmBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 前台显示banner的控制器
 * @Author: zhangqi
 * @CreateTime: 2021/4/2113:36
 * @Company: MGL
 */
@RestController
@RequestMapping("/educms/banner")
@Api("客户端首页Banner列表")
public class CrmBannerClientController {
    @Autowired
    private CrmBannerService bannerService;

    @ApiOperation(value = "获取首页banner")
    @GetMapping("getAllBanner")
    public R index() {
        List<CrmBanner> list = bannerService.selectAllBanner();
        return R.ok().data("bannerList", list);
    }
}
