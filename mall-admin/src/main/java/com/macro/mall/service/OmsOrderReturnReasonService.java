package com.macro.mall.service;

import com.macro.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * Order reason managementService
 * Created by macro on 2018/10/17.
 */
public interface OmsOrderReturnReasonService {
    /**
     * Reason for adding order
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * Modify return reason
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * Batch delete reason for returns
     */
    int delete(List<Long> ids);

    /**
     * Get the reason for return
     */
    List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

    /**
     * Batch Modify return reason status
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * Get details of a single return reason
     */
    OmsOrderReturnReason getItem(Long id);
}
