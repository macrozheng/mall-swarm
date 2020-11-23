package com.macro.mall.dao;

import com.macro.mall.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Customized coupons and product category relationship management Dao
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponProductCategoryRelationDao {
    /**
     * Batch creation
     */
    int insertList(@Param("list")List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
