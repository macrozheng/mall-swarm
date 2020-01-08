package com.macro.mall.portal.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.model.SmsCouponHistory;
import com.macro.mall.portal.domain.CartPromotionItem;
import com.macro.mall.portal.domain.SmsCouponHistoryDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserCoupon managementService
 * Created by macro on 2018/8/29.
 */
public interface UmsMemberCouponService {
    /**
     * MemberAdd coupon
     */
    @Transactional
    CommonResult add(Long couponId);

    /**
     * Get coupon list
     * @param useStatus Coupon status of use
     */
    List<SmsCouponHistory> list(Integer useStatus);

    /**
     * Get available coupons according to Shopping car information
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);
}
