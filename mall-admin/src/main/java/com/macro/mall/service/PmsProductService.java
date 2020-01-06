package com.macro.mall.service;

import com.macro.mall.dto.PmsProductParam;
import com.macro.mall.dto.PmsProductQueryParam;
import com.macro.mall.dto.PmsProductResult;
import com.macro.mall.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Product management Service
 * Created by macro on 2018/4/26.
 */
public interface PmsProductService {
    /**
     * Create product
     */
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    int create(PmsProductParam productParam);

    /**
     * Get update information based on product number
     */
    PmsProductResult getUpdateInfo(Long id);

    /**
     * Update product
     */
    @Transactional
    int update(Long id, PmsProductParam productParam);

    /**
     * Search for Products
     */
    List<PmsProduct> list(PmsProductQueryParam productQueryParam, Integer pageSize, Integer pageNum);

    /**
     * Edit review status in bulk
     * @param ids Product id
     * @param verifyStatus Approval Status
     * @param detail Review details
     */
    @Transactional
    int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

    /**
     * Batch modify product Up-shelf status
     */
    int updatePublishStatus(List<Long> ids, Integer publishStatus);

    /**
     * Modify product recommendation status in bulk
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Modify new product status in batches
     */
    int updateNewStatus(List<Long> ids, Integer newStatus);

    /**
     * Delete items in bulk
     */
    int updateDeleteStatus(List<Long> ids, Integer deleteStatus);

    /**
     * The fuzzy query based on product name or article number
     */
    List<PmsProduct> list(String keyword);
}
