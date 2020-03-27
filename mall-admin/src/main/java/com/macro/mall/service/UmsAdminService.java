package com.macro.mall.service;

import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.UpdateAdminPasswordParam;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsResource;
import com.macro.mall.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Backoffice Management Service
 * Created by macro on 2018/4/26.
 */
public interface UmsAdminService {
    /**
     * According to username get Backoffice Management
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * Registration function
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * Login function
     * @param username username
     * @param password password
     * @return Generated JWT token
     */
    String login(String username,String password);

    /**
     * Refresh token function
     * @param oldToken Old token
     */
    String refreshToken(String oldToken);

    /**
     * get user according to user id
     */
    UmsAdmin getItem(Long id);

    /**
     * query users according to username or nickname
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Modify specified User information
     */
    int update(Long id, UmsAdmin admin);

    /**
     * Delete the specified user
     */
    int delete(Long id);

    /**
     * Modify user role relationships
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * Get user for role
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 修改用户的+-权限
     */
    @Transactional
    int updatePermission(Long adminId, List<Long> permissionIds);

    /**
     * Get all user permissions (including role permissions and +-permissions)
     */
    List<UmsPermission> getPermissionList(Long adminId);

    /**
     * 修改密码
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}
