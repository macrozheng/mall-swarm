package com.macro.mall.dao;

import com.macro.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Coupon and Product Relationship Custom Dao
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponProductRelationDao {
    int insertList(@Param("list")List<SmsCouponProductRelation> productRelationList);
}
