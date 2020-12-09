package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * Product category custom Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    /**
     * Get product category and its subcategories
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
