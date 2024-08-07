package com.macro.mall.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminParam {
    @Schema(title = "用户名", required = true)
    @NotEmpty
    private String username;
    @Schema(title = "密码", required = true)
    @NotEmpty
    private String password;
    @Schema(title = "用户头像")
    private String icon;
    @Schema(title = "邮箱")
    @Email
    private String email;
    @Schema(title = "用户昵称")
    private String nickName;
    @Schema(title = "备注")
    private String note;
}
