package com.macro.mall.service;

import com.macro.mall.dto.SmsCouponParam;
import com.macro.mall.model.SmsCoupon;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Coupon managementService
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponService {
    /**
     * Add coupon
     */
    @Transactional
    int create(SmsCouponParam couponParam);

    /**
     * according to Coupon id,Delete coupon
     */
    @Transactional
    int delete(Long id);

    /**
     * according to Coupon id,Update coupon information
     */
    @Transactional
    int update(Long id, SmsCouponParam couponParam);

    /**
     * Get a list of coupons
     */
    List<SmsCoupon> list(String name, Integer type, Integer pageSize, Integer pageNum);

    /**
     * Get coupon details
     *
     * @param id Coupon table id
     */
    SmsCouponParam getItem(Long id);
}
