package com.macro.mall.demo.controller;

/**
 * Created by macro on 2019/10/18.
 */

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.demo.dto.UmsAdminLoginParam;
import com.macro.mall.demo.service.FeignAdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Feign调用mall-admin接口示例
 */
@Tag(name = "FeignAdminController", description = "Feign调用mall-admin接口示例")
@RestController
@RequestMapping("/feign/admin")
public class FeignAdminController {
    @Autowired
    private FeignAdminService adminService;

    @Operation(summary = "后台管理员登录")
    @PostMapping("/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam loginParam) {
        return adminService.login(loginParam);
    }

    @Operation(summary = "获取商品列表")
    @GetMapping("/getBrandList")
    public CommonResult getBrandList(){
        return adminService.getList();
    }
}
