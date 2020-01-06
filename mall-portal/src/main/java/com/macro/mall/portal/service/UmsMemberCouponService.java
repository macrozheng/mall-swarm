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
     * 获取优惠券列表
     * @param useStatus 优惠券的status of use
     */
    List<SmsCouponHistory> list(Integer useStatus);

    /**
     * according to购物车信息获取可用优惠券
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);
}
