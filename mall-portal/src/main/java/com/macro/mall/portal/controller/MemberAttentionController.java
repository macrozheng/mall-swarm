package com.macro.mall.portal.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.portal.domain.MemberBrandAttention;
import com.macro.mall.portal.service.MemberAttentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Members focus on brand management controller
 * Created by macro on 2018/8/2.
 */
@Controller
@Api(tags = "MemberAttentionController", description = "Members focus on brand management")
@RequestMapping("/member/attention")
public class MemberAttentionController {
    @Autowired
    private MemberAttentionService memberAttentionService;
    @ApiOperation("Add brand attention")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody MemberBrandAttention memberBrandAttention) {
        int count = memberAttentionService.add(memberBrandAttention);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("Unfollow")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(Long memberId, Long brandId) {
        int count = memberAttentionService.delete(memberId,brandId);
        if(count>0){
            return CommonResult.success(count);
        }else{
            return CommonResult.failed();
        }
    }

    @ApiOperation("Show follow list")
    @RequestMapping(value = "/list/{memberId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<MemberBrandAttention>> list(@PathVariable Long memberId) {
        List<MemberBrandAttention> memberBrandAttentionList = memberAttentionService.list(memberId);
        return CommonResult.success(memberBrandAttentionList);
    }
}
