package com.macro.mall.demo.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.demo.service.FeignPortalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign calls mall-portal interface example
 * Created by macro on 2019/10/18.
 */
@Api(tags = "FeignPortalController", description = "Feign calls mall-portal interface example")
@RestController
@RequestMapping("/feign/portal")
public class FeignPortalController {

    @Autowired
    private FeignPortalService portalService;

    @PostMapping("/login")
    public CommonResult login(@RequestParam String username, @RequestParam String password) {
        return portalService.login(username, password);
    }

    @GetMapping("/cartList")
    public CommonResult cartList() {
        return portalService.list();
    }
}
