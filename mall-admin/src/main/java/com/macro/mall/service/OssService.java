package com.macro.mall.service;

import com.macro.mall.dto.OssCallbackResult;
import com.macro.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss upload management Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {
    /**
     * oss upload policy generation
     */
    OssPolicyResult policy();
    /**
     * oss upload success callback
     */
    OssCallbackResult callback(HttpServletRequest request);
}
