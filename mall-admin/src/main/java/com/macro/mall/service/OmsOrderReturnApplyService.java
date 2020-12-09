package com.macro.mall.service;

import com.macro.mall.dto.OmsOrderReturnApplyResult;
import com.macro.mall.dto.OmsReturnApplyQueryParam;
import com.macro.mall.dto.OmsUpdateStatusParam;
import com.macro.mall.model.OmsOrderReturnApply;

import java.util.List;

/**
 * Return Request Service Management
 * Created by macro on 2018/10/18.
 */
public interface OmsOrderReturnApplyService {
    /**
     * Paging query application
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * Delete applications in bulk
     */
    int delete(List<Long> ids);

    /**
     * Modify application status
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * Get specified application details
     */
    OmsOrderReturnApplyResult getItem(Long id);
}
