package com.macro.mall.portal.service;

import com.macro.mall.model.OmsCartItem;
import com.macro.mall.portal.domain.CartProduct;
import com.macro.mall.portal.domain.CartPromotionItem;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Shopping cart managementService
 * Created by macro on 2018/8/2.
 */
public interface OmsCartItemService {
    /**
     * Check whether the product is included in the shopping cart, there is an increase in quantity, no addition to the shopping cart
     */
    @Transactional
    int add(OmsCartItem cartItem);

    /**
     * Get Shopping Cart List by Member Number
     */
    List<OmsCartItem> list(Long memberId);

    /**
     * Get Shopping Cart List with Promotion Event Information
     */
    List<CartPromotionItem> listPromotion(Long memberId);

    /**
     * Modify the Count of a Shopping Cart Product
     */
    int updateQuantity(Long id, Long memberId, Integer quantity);

    /**
     * Delete items in Shopping cart in batch
     */
    int delete(Long memberId,List<Long> ids);

    /**
     *Get Product information for selecting product specifications in the shopping cart
     */
    CartProduct getCartProduct(Long productId);

    /**
     * Modify specifications of items in shopping cart
     */
    @Transactional
    int updateAttr(OmsCartItem cartItem);

    /**
     * Empty shopping cart
     */
    int clear(Long memberId);
}
