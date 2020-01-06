package com.macro.mall.portal.service;

import com.macro.mall.portal.domain.MemberReadHistory;

import java.util.List;

/**
 * Member浏览记录managementService
 * Created by macro on 2018/8/3.
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取User浏览历史记录
     */
    List<MemberReadHistory> list(Long memberId);
}
