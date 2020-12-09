package com.macro.mall.auth.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Oauth2 get Token return information package
 * Created by macro on 2020/7/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class Oauth2TokenDto {
    @ApiModelProperty("Access token")
    private String token;
    @ApiModelProperty("Swipe token")
    private String refreshToken;
    @ApiModelProperty("Access token header prefix")
    private String tokenHead;
    @ApiModelProperty("Expires In (seconds)")
    private int expiresIn;
}
