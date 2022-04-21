package com.macro.mall.auth.service;

import com.macro.mall.auth.config.FeignConfig;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by macro on 2019/10/18.
 */
@FeignClient(value = "mall-admin",configuration = FeignConfig.class)
public interface UmsAdminService {
    @PostMapping("/brand/update/factoryStatus")
    CommonResult updateFactoryStatus(@RequestParam List<Long> ids, @RequestParam Integer factoryStatus);
    @GetMapping("/admin/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
    @PostMapping("/brand/update/factoryStatus1")
    CommonResult updateFactoryStatus1(@RequestParam List<Long> ids, @RequestParam Integer factoryStatus);
}
