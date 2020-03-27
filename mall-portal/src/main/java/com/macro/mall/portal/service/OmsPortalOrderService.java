package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.ConfirmOrderResult;
import com.macro.mall.portal.domain.OrderParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Order Management Service
 * Created by macro on 2018/8/30.
 */
public interface OmsPortalOrderService {
    /**
     * Generate confirmation information based on user shopping cart information
     */
    ConfirmOrderResult generateConfirmOrder();

    /**
     * according to submit information
     */
    @Transactional
    Map<String, Object> generateOrder(OrderParam orderParam);

    /**
     * Callback after successful payment
     */
    @Transactional
    Integer paySuccess(Long orderId);

    /**
     * Automatic cancellation of overtime orders
     */
    @Transactional
    Integer cancelTimeOutOrder();

    /**
     * Cancel single overtime order
     */
    @Transactional
    void cancelOrder(Long orderId);

    /**
     * Send delayed message to cancel order
     */
    void sendDelayMessageCancelOrder(Long orderId);
}
