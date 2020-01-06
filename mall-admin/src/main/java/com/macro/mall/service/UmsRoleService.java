package com.macro.mall.service;

import com.macro.mall.model.UmsPermission;
import com.macro.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Background role management Service
 * Created by macro on 2018/9/30.
 */
public interface UmsRoleService {
    /**
     * Add role
     */
    int create(UmsRole role);

    /**
     * Modify role information
     */
    int update(Long id, UmsRole role);

    /**
     * Delete roles in bulk
     */
    int delete(List<Long> ids);

    /**
     * Get specified role permissions
     */
    List<UmsPermission> getPermissionList(Long roleId);

    /**
     * Modify the permissions of the specified role
     */
    @Transactional
    int updatePermission(Long roleId, List<Long> permissionIds);

    /**
     * Get list of roles
     */
    List<UmsRole> list();
}
