package com.macro.mall.service;

import com.macro.mall.model.SmsFlashPromotion;

import java.util.List;

/**
 * Limited-time purchase activities Service
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionService {
    /**
     * Add event
     */
    int create(SmsFlashPromotion flashPromotion);

    /**
     * Edit specified event
     */
    int update(Long id, SmsFlashPromotion flashPromotion);

    /**
     * Delete single event
     */
    int delete(Long id);

    /**
     * Modify online and offline status
     */
    int updateStatus(Long id, Integer status);

    /**
     * Get details
     */
    SmsFlashPromotion getItem(Long id);

    /**
     * Pagination query activity
     */
    List<SmsFlashPromotion> list(String keyword, Integer pageSize, Integer pageNum);
}
