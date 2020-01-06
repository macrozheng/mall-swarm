package com.macro.mall.service;

import com.macro.mall.model.SmsCouponHistory;

import java.util.List;

/**
 * Coupon collection records
 * Created by macro on 2018/11/6.
 */
public interface SmsCouponHistoryService {
    /**
     * Paging for coupon collection records
     * @param couponId Coupon id
     * @param useStatus status of use
     * @param orderSn Use order number
     */
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}
