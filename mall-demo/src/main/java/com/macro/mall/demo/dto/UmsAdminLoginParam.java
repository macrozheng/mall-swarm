package com.macro.mall.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录参数
 * Created by macro on 2018/4/26.
 */
@Getter
@Setter
public class UmsAdminLoginParam {
    @Schema(title = "用户名", required = true)
    private String username;
    @Schema(title = "密码", required = true)
    private String password;
}
