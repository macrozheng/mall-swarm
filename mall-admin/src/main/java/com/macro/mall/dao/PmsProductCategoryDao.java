package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * Product Category Custom Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    /**
     * 获取商品分类包括子分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
