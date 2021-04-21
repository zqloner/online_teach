package com.atguigu.servicecms.service.impl;

import com.atguigu.servicecms.entity.CrmBanner;
import com.atguigu.servicecms.mapper.CrmBannerMapper;
import com.atguigu.servicecms.service.CrmBannerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务实现类
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-21
 */
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

        //查询所有banner
        @Cacheable(value = "banner",key = "'selectIndexList'")
        @Override
        public List<CrmBanner> selectAllBanner() {

            //根据id进行降序排列，显示排列之后前两条记录
            QueryWrapper<CrmBanner> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("id");
            //last方法，拼接sql语句
            wrapper.last("limit 2");
            List<CrmBanner> list = baseMapper.selectList(null);
            return list;
        }

    @Override
    public void pageBanner(Page<CrmBanner> pageParam, Object o) {
        baseMapper.selectPage(pageParam,null);
    }

    @Override
    public CrmBanner getBannerById(String id) {
        return baseMapper.selectById(id);
    }

    @CacheEvict(value = "banner", allEntries=true)
    @Override
    public void saveBanner(CrmBanner banner) {
        baseMapper.insert(banner);
    }

    @CacheEvict(value = "banner", allEntries=true)
    @Override
    public void updateBannerById(CrmBanner banner) {
        baseMapper.updateById(banner);
    }

    @CacheEvict(value = "banner", allEntries=true)
    @Override
    public void removeBannerById(String id) {
        baseMapper.deleteById(id);
    }
}
