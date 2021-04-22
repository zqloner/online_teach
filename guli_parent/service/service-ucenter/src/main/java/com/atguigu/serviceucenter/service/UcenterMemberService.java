package com.atguigu.serviceucenter.service;

import com.atguigu.serviceucenter.entity.UcenterMember;
import com.atguigu.serviceucenter.entity.vo.LoginVo;
import com.atguigu.serviceucenter.entity.vo.RegisterVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author zhangqi
 * @since 2021-04-22
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    public String login(LoginVo loginVo);

    public void register(RegisterVo registerVo);
}
