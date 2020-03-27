package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * User login parameter
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminParam {
    @ApiModelProperty(value = "username", required = true)
    @NotEmpty(message = "username cannot be empty")
    private String username;
    @ApiModelProperty(value = "password", required = true)
    @NotEmpty(message = "password cannot be empty")
    private String password;
    @ApiModelProperty(value = "profile picture")
    private String icon;
    @ApiModelProperty(value = "Mailbox")
    @Email(message = "Mailbox format is not legal")
    private String email;
    @ApiModelProperty(value = "User's Nickname")
    private String nickName;
    @ApiModelProperty(value = "Note")
    private String note;
}
