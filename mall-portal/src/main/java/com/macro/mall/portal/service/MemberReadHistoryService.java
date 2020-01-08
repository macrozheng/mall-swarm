package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.MemberReadHistory;

import java.util.List;

/**
 * Member browsing history managementService
 * Created by macro on 2018/8/3.
 */
public interface MemberReadHistoryService {
    /**
     * Generate browsing history
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * Batch Delete browsing history
     */
    int delete(List<String> ids);

    /**
     * Get User browsing history
     */
    List<MemberReadHistory> list(Long memberId);
}
