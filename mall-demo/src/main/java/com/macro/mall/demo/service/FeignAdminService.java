package com.macro.mall.demo.service;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.demo.dto.UmsAdminLoginParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by macro on 2019/10/18.
 */
@FeignClient("mall-admin")
public interface FeignAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam loginParam);

    @GetMapping("/brand/listAll")
    CommonResult getList();
}
