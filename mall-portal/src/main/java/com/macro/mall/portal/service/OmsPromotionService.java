package com.macro.mall.portal.service;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartPromotionItem;

import java.util.List;

/**
 * Created by macro on 2018/8/27.
 * Promotion managementService
 */
public interface OmsPromotionService {
    /**
     * Calculate Promotion Event Information in Shopping Cart
     * @param cartItemList Shopping车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
