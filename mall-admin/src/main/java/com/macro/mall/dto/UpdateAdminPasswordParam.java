package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

/**
 * Modify username and password parameters
 * Created by macro on 2019/10/9.
 */
@Getter
@Setter
public class UpdateAdminPasswordParam {
    @NotEmpty
    @ApiModelProperty(value = "Username", required = true)
    private String username;
    @NotEmpty
    @ApiModelProperty(value = "Old Password", required = true)
    private String oldPassword;
    @NotEmpty
    @ApiModelProperty(value = "New Password", required = true)
    private String newPassword;
}
