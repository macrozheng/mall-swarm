package com.macro.mall.service;

import com.macro.mall.dto.SmsFlashPromotionSessionDetail;
import com.macro.mall.model.SmsFlashPromotionSession;

import java.util.List;

/**
 * Time-limited purchases Service
 * Created by macro on 2018/11/16.
 */
public interface SmsFlashPromotionSessionService {
    /**
     * Add Sessions
     */
    int create(SmsFlashPromotionSession promotionSession);

    /**
     * Modify Sessions
     */
    int update(Long id, SmsFlashPromotionSession promotionSession);

    /**
     * Modify SessionsEnabled
     */
    int updateStatus(Long id, Integer status);

    /**
     * Delete Session
     */
    int delete(Long id);

    /**
     * Get details
     */
    SmsFlashPromotionSession getItem(Long id);

    /**
     * Get the list of Sessions according to Enabled
     */
    List<SmsFlashPromotionSession> list();

    /**
     * Get all Optional Sessions and their number
     */
    List<SmsFlashPromotionSessionDetail> selectList(Long flashPromotionId);
}
