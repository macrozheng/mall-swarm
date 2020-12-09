package com.macro.mall.service;

import com.macro.mall.dto.UmsMenuNode;
import com.macro.mall.model.UmsMenu;

import java.util.List;

/**
 * Admin menu management Service
 * Created by macro on 2020/2/2.
 */
public interface UmsMenuService {
    /**
     * Create admin menu
     */
    int create(UmsMenu umsMenu);

    /**
     * Modify the admin menu
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * Get menu details based on ID
     */
    UmsMenu getItem(Long id);

    /**
     * Delete menu based on ID
     */
    int delete(Long id);

    /**
     * Paging query admin menu
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * Tree structure returns all menu list
     */
    List<UmsMenuNode> treeList();

    /**
     * Modify menu display status
     */
    int updateHidden(Long id, Integer hidden);
}
