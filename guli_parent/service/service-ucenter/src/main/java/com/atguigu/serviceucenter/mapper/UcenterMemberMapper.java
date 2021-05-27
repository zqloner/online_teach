package com.atguigu.serviceucenter.mapper;

import com.atguigu.serviceucenter.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-22
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {

    //查询某一天注册人数
    Integer selectRegisterCount(String day);
}
