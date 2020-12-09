package com.macro.mall.dao;

import com.macro.mall.model.PmsProductCategoryAttributeRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom product classification and attribute relationship Dao
 * Created by macro on 2018/5/23.
 */
public interface PmsProductCategoryAttributeRelationDao {
    /**
     * Bulk creation
     */
    int insertList(@Param("list") List<PmsProductCategoryAttributeRelation> productCategoryAttributeRelationList);
}
