package com.macro.mall.portal.service;

import com.macro.mall.model.UmsMemberReceiveAddress;

import java.util.List;

/**
 * User地址managementService
 * Created by macro on 2018/8/28.
 */
public interface UmsMemberReceiveAddressService {
    /**
     * 添加Shipping address
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * 删除Shipping address
     * @param id 地址表的id
     */
    int delete(Long id);

    /**
     * 修改Shipping address
     * @param id 地址表的id
     * @param address 修改的Shipping address信息
     */
    int update(Long id, UmsMemberReceiveAddress address);

    /**
     * 返回当前User的Shipping address
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * 获取地址详情
     * @param id 地址id
     */
    UmsMemberReceiveAddress getItem(Long id);
}
