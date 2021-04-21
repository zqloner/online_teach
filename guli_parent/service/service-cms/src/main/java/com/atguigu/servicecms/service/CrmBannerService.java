package com.atguigu.servicecms.service;

import com.atguigu.servicecms.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-21
 */
public interface CrmBannerService extends IService<CrmBanner> {

    //查询所有banner
    List<CrmBanner> selectAllBanner();

    public void pageBanner(Page<CrmBanner> pageParam, Object o);

    public CrmBanner getBannerById(String id);

    public void saveBanner(CrmBanner banner);

    public void updateBannerById(CrmBanner banner);

    public void removeBannerById(String id);
}
