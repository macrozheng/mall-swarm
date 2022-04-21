package com.macro.mall.auth.controller;

import com.macro.mall.auth.domain.Oauth2TokenDto;
import com.macro.mall.auth.service.UmsAdminService;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.constant.AuthConstant;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义Oauth2获取令牌接口
 * Created by macro on 2020/7/17.
 */
@RestController
@Api(tags = "AuthController", description = "认证中心登录认证")
@RequestMapping("/oauth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;
    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("Oauth2获取token")
    @RequestMapping(value ="/seata",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码")
    })
    public CommonResult<Oauth2TokenDto> postAccessToken(@ApiIgnore Principal principal, @ApiIgnore @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
        return CommonResult.success(oauth2TokenDto);
    }
    @GlobalTransactional
    @ApiOperation("测试seata分布式事务")
    @RequestMapping(value ="/token",method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码")
    })
    public CommonResult testSeata(@RequestParam("ids") List<Long> ids, @RequestParam("factoryStatus") Integer factoryStatus) {
        List firstids = new ArrayList();
        List secondids = new ArrayList();
        firstids.add(ids.get(0));
        secondids.add(ids.get(1));
        umsAdminService.updateFactoryStatus(firstids, factoryStatus);
        return umsAdminService.updateFactoryStatus1(secondids, factoryStatus);
    }
}
