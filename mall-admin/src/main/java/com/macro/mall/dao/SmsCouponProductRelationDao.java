package com.macro.mall.dao;

import com.macro.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom Coupon and Product Relationship Dao
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponProductRelationDao {
    /**
     * Batch creation
     */
    int insertList(@Param("list")List<SmsCouponProductRelation> productRelationList);
}
