package com.macro.mall.service;

import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsResource;

import java.util.List;

/**
 * Admin user cache operation class
 * Created by macro on 2020/3/13.
 */
public interface UmsAdminCacheService {
    /**
     * Delete Admin user cache
     */
    void delAdmin(Long adminId);

    /**
     * Get Admin user cache
     */
    UmsAdmin getAdmin(Long adminId);

    /**
     * Set Admin user cache
     */
    void setAdmin(UmsAdmin admin);
}
