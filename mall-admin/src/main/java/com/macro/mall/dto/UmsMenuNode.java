package com.macro.mall.dto;

import com.macro.mall.model.UmsMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Admin menu node package
 * Created by macro on 2020/2/4.
 */
@Getter
@Setter
public class UmsMenuNode extends UmsMenu {
    @ApiModelProperty(value = "Sub-menu")
    private List<UmsMenuNode> children;
}
