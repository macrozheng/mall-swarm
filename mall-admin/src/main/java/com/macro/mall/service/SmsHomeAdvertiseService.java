package com.macro.mall.service;

import com.macro.mall.model.SmsHomeAdvertise;

import java.util.List;

/**
 * Home Advertising management Service
 * Created by macro on 2018/11/7.
 */
public interface SmsHomeAdvertiseService {
    /**
     * Add ads
     */
    int create(SmsHomeAdvertise advertise);

    /**
     * Bulk Delete ad
     */
    int delete(List<Long> ids);

    /**
     * Modify online and offline status
     */
    int updateStatus(Long id, Integer status);

    /**
     * Get ad details
     */
    SmsHomeAdvertise getItem(Long id);

    /**
     * Update ads
     */
    int update(Long id, SmsHomeAdvertise advertise);

    /**
     * Paging query ads
     */
    List<SmsHomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum);
}
