package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;
    @ApiModelProperty(value = "用户头像")
    private String icon;
    @ApiModelProperty(value = "邮箱")
    @Email
    private String email;
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    @ApiModelProperty(value = "备注")
    private String note;
}
