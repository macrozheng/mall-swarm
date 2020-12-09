package com.macro.mall.service;

import com.macro.mall.dto.PmsProductCategoryParam;
import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;
import com.macro.mall.model.PmsProductCategory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product Category Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductCategoryService {
    /**
     * Create product categories
     */
    @Transactional
    int create(PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * Modify product category
     */
    @Transactional
    int update(Long id, PmsProductCategoryParam pmsProductCategoryParam);

    /**
     * Get product category by page
     */
    List<PmsProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * Delete product category
     */
    int delete(Long id);

    /**
     * Get product Category based on ID
     */
    PmsProductCategory getItem(Long id);

    /**
     * Batch edit navigation status
     */
    int updateNavStatus(List<Long> ids, Integer navStatus);

    /**
     * Batch modify display status
     */
    int updateShowStatus(List<Long> ids, Integer showStatus);

    /**
     * Get product Category With Children Item
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
