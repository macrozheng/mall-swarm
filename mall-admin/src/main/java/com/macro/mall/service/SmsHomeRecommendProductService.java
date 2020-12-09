package com.macro.mall.service;

import com.macro.mall.model.SmsHomeRecommendProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Home Popular recommendation management Service
 * Created by macro on 2018/11/7.
 */
public interface SmsHomeRecommendProductService {
    /**
     * Add a homepage recommendation
     */
    @Transactional
    int create(List<SmsHomeRecommendProduct> homeRecommendProductList);

    /**
     * Modify recommendation sort
     */
    int updateSort(Long id, Integer sort);

    /**
     * Remove recommendations in bulk
     */
    int delete(List<Long> ids);

    /**
     * Update recommendation status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Pagination query recommendation
     */
    List<SmsHomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
