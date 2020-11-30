package com.macro.mall.service;

import com.macro.mall.model.UmsResource;

import java.util.List;
import java.util.Map;

/**
 * Admin Resource Management Service
 * Created by macro on 2020/2/2.
 */
public interface UmsResourceService {
    /**
     * Add resource
     */
    int create(UmsResource umsResource);

    /**
     * Modify resources
     */
    int update(Long id, UmsResource umsResource);

    /**
     * Get resource details
     */
    UmsResource getItem(Long id);

    /**
     * Delete resource
     */
    int delete(Long id);

    /**
     * Paging query resources
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum);

    /**
     * Query all resources
     */
    List<UmsResource> listAll();

    /**
     * Initialize resource role rules
     */
    Map<String,List<String>> initResourceRolesMap();
}
