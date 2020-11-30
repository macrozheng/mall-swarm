package com.macro.mall.service;

import com.macro.mall.model.UmsMenu;
import com.macro.mall.model.UmsResource;
import com.macro.mall.model.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Admin role management Service
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
     * Get a list of all roles
     */
    List<UmsRole> list();

    /**
     * Paging to get the list of roles
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * Get the corresponding menu according to the administrator ID
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * Get role-related menu
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * Get role-related resources
     */
    List<UmsResource> listResource(Long roleId);

    /**
     * Assign menus to roles
     */
    @Transactional
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * Assign resources to roles
     */
    @Transactional
    int allocResource(Long roleId, List<Long> resourceIds);
}
