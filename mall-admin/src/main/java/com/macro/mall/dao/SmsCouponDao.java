package com.macro.mall.dao;

import com.macro.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * Custom Coupon Management Dao
 * Created by macro on 2018/8/29.
 */
public interface SmsCouponDao {
    /**
     * Get coupon details including binding relationship
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
