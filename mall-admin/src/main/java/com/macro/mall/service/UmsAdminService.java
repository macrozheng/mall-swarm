package com.macro.mall.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.domain.UserDto;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.UpdateAdminPasswordParam;
import com.macro.mall.model.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * back-end Administrator Service
 * Created by macro on 2018/4/26.
 */
public interface UmsAdminService {
    /**
     * Get back-end administrator based on user name
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * Registration function
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * Login function
     * @param username Username
     * @param password Password
     * @return Call the certification center to return the result
     */
    CommonResult login(String username, String password);

    /**
     * Get users based on user id
     */
    UmsAdmin getItem(Long id);

    /**
     * Paging query users based on user name or nickname
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Modify specified user information
     */
    int update(Long id, UmsAdmin admin);

    /**
     * Delete specified user
     */
    int delete(Long id);

    /**
     * Modify user role relationship
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * Get users for roles
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * Get the accessible resources of the specified user
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * change Password
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * Get user information
     */
    UserDto loadUserByUsername(String username);

    /**
     * Get the currently logged in admin user
     */
    UmsAdmin getCurrentAdmin();
}
