package com.macro.mall.dto;

import com.macro.mall.model.OmsCompanyAddress;
import com.macro.mall.model.OmsOrderReturnApply;
import lombok.Getter;
import lombok.Setter;

/**
 * Application Information Package
 * Created by macro on 2018/10/18.
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    private OmsCompanyAddress companyAddress;
}
