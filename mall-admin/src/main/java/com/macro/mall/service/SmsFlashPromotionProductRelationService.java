package com.macro.mall.service;

import com.macro.mall.dto.SmsFlashPromotionProduct;
import com.macro.mall.model.SmsFlashPromotionProductRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Limited-time purchase of Products Related Management Services
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionProductRelationService {
    /**
     * Add Related in bulk
     */
    @Transactional
    int create(List<SmsFlashPromotionProductRelation> relationList);

    /**
     * Edit related information
     */
    int update(Long id, SmsFlashPromotionProductRelation relation);

    /**
     * Delete association
     */
    int delete(Long id);

    /**
     * Get Related details
     */
    SmsFlashPromotionProductRelation getItem(Long id);

    /**
     * Paging for related products and promotions
     *
     * @param flashPromotionId        Limited-time purchase id
     * @param flashPromotionSessionId Time-limited purchase of Sessions id
     */
    List<SmsFlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum);

    /**
     * Get the number of product relationships according to the activity and Sessions id
     *
     * @param flashPromotionId
     * @param flashPromotionSessionId
     * @return
     */
    long getCount(Long flashPromotionId, Long flashPromotionSessionId);
}
