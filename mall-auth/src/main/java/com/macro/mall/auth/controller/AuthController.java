package com.macro.mall.auth.controller;

import com.macro.mall.auth.domain.Oauth2TokenDto;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.constant.AuthConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.Map;

/**
 * Customize Oauth2 get token interface
 * Created by macro on 2020/7/17.
 */
@RestController
@Api(tags = "AuthController", description = "Authentication center login authentication")
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @ApiOperation("Oauth2 get token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "Authorization model", required = true),
            @ApiImplicitParam(name = "client_id", value = "Oauth2 client ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2 client secret key", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "Refresh token"),
            @ApiImplicitParam(name = "username", value = "Login Username"),
            @ApiImplicitParam(name = "password", value = "Login Password")
    })
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public CommonResult<Oauth2TokenDto> postAccessToken(@ApiIgnore Principal principal, @ApiIgnore @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();

        return CommonResult.success(oauth2TokenDto);
    }
}
