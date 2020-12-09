package com.macro.mall.service;

import com.macro.mall.model.SmsHomeBrand;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Home Brand Management Service
 * Created by macro on 2018/11/6.
 */
public interface SmsHomeBrandService {
    /**
     * Add Home Brand Recommendations
     */
    @Transactional
    int create(List<SmsHomeBrand> homeBrandList);

    /**
     * Modify Brand Recommendation Sort
     */
    int updateSort(Long id, Integer sort);

    /**
     * Remove brand in bulk
     */
    int delete(List<Long> ids);

    /**
     * Update recommendation status
     */
    int updateRecommendStatus(List<Long> ids, Integer recommendStatus);

    /**
     * Paging query brand recommendation
     */
    List<SmsHomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum);
}
