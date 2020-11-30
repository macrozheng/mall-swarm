package com.macro.mall.service;

import com.macro.mall.dto.PmsProductAttributeCategoryItem;
import com.macro.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * Product attribute classification service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductAttributeCategoryService {
    /**
     * Create attribute Category
     */
    int create(String name);

    /**
     * Modify attribute Category
     */
    int update(Long id, String name);

    /**
     * Delete attribute Category
     */
    int delete(Long id);

    /**
     * Get attribute Category details
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * Pagination query attribute Category
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * Get the attribute category containing the attribute
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
