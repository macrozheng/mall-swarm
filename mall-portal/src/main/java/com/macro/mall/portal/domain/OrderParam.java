package com.macro.mall.portal.domain;

/**
 * Parameter passed in when order is generated
 * Created by macro on 2018/8/30.
 */
public class OrderParam {
    //Shipping addressid
    private Long memberReceiveAddressId;
    //Coupon id
    private Long couponId;
    //Integration number used
    private Integer useIntegration;
    //Payment method
    private Integer payType;

    public Long getMemberReceiveAddressId() {
        return memberReceiveAddressId;
    }

    public void setMemberReceiveAddressId(Long memberReceiveAddressId) {
        this.memberReceiveAddressId = memberReceiveAddressId;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }
}
