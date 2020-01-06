package com.macro.mall.service;

import com.macro.mall.model.OmsCompanyAddress;

import java.util.List;

/**
 * Shipping address management service
 * Created by macro on 2018/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * Get all Shipping address
     */
    List<OmsCompanyAddress> list();
}
