package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.MemberBrandAttention;

import java.util.List;

/**
 * Member关注Service
 * Created by macro on 2018/8/2.
 */
public interface MemberAttentionService {
    /**
     * 添加关注
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     */
    int delete(Long memberId, Long brandId);

    /**
     * 获取User关注列表
     */
    List<MemberBrandAttention> list(Long memberId);
}
