package com.macro.mall.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * User login parameter
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "username", required = true)
    private String username;
    @ApiModelProperty(value = "password", required = true)
    private String password;
}
