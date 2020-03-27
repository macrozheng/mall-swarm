package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 * Member Management Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {
    /**
     * Get members by username
     */
    UmsMember getByUsername(String username);

    /**
     * Get members by member number
     */
    UmsMember getById(Long id);

    /**
     * User registration
     */
    @Transactional
    void register(String username, String password, String telephone, String authCode);

    /**
     * Generate verification code
     */
    String generateAuthCode(String telephone);

    /**
     * Change Password
     */
    @Transactional
    void updatePassword(String telephone, String password, String authCode);

    /**
     * Get the currently logged in Member
     */
    UmsMember getCurrentMember();

    /**
     * Modify member points based on member id
     */
    void updateIntegration(Long id,Integer integration);


    /**
     * Get user information
     */
    UserDetails loadUserByUsername(String username);

    /**
     * Get token after login
     */
    String login(String username, String password);

    /**
     * Refresh token
     */
    String refreshToken(String token);
}
