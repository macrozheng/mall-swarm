package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * MembermanagementService
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {
    /**
     * according tousername获取Member
     */
    UmsMember getByUsername(String username);

    /**
     * according toMember编号获取Member
     */
    UmsMember getById(Long id);

    /**
     * User registration
     */
    @Transactional
    CommonResult register(String username, String password, String telephone, String authCode);

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 修改password
     */
    @Transactional
    CommonResult updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录Member
     */
    UmsMember getCurrentMember();

    /**
     * according toMemberid修改Member积分
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * Get user information
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 登录后获取token
     */
    String login(String username, String password);

    /**
     * Refresh token
     */
    String refreshToken(String token);
}
