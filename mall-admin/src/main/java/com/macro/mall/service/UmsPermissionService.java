package com.macro.mall.service;

import com.macro.mall.dto.UmsPermissionNode;
import com.macro.mall.model.UmsPermission;

import java.util.List;

/**
 * Background user rights management Service
 * Created by macro on 2018/9/29.
 */
public interface UmsPermissionService {
    /**
     * Add permissions
     */
    int create(UmsPermission permission);

    /**
     * Modify permissions
     */
    int update(Long id, UmsPermission permission);

    /**
     * Delete permissions in bulk
     */
    int delete(List<Long> ids);

    /**
     * Returns all permissions in a hierarchical structure
     */
    List<UmsPermissionNode> treeList();

    /**
     * Get all permissions
     */
    List<UmsPermission> list();
}
