package com.macro.mall.portal.service;

import com.macro.mall.model.UmsMemberReceiveAddress;

import java.util.List;

/**
 * User address managementService
 * Created by macro on 2018/8/28.
 */
public interface UmsMemberReceiveAddressService {
    /**
     * Add shipping address
     */
    int add(UmsMemberReceiveAddress address);

    /**
     * Delete shipping address
     * @param id Id of the address table
     */
    int delete(Long id);

    /**
     * Modify shipping address
     * @param id Id of the address table
     * @param address Modified Shipping address information
     */
    int update(Long id, UmsMemberReceiveAddress address);

    /**
     * Returns the Shipping address of the current user
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * Get address details
     * @param id Address id
     */
    UmsMemberReceiveAddress getItem(Long id);
}
