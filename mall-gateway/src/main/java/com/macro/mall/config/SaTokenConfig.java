package com.macro.mall.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaHttpMethod;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.common.constant.AuthConstant;
import com.macro.mall.util.StpMemberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;

/**
 * @auther macrozheng
 * @description Sa-Token相关配置
 * @date 2023/11/28
 * @github https://github.com/macrozheng
 */
@Configuration
public class SaTokenConfig {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 注册Sa-Token全局过滤器
     * 注意：为了避免与Spring Cloud Gateway的过滤器冲突，
     * 这里只拦截实际的服务端点，不拦截网关路由路径
     */
    @Bean
    public SaReactorFilter getSaReactorFilter(IgnoreUrlsConfig ignoreUrlsConfig) {
        // 创建排除列表，包含网关路由路径和白名单路径
        List<String> excludeList = new ArrayList<>();

        // 添加默认的白名单URL
        excludeList.addAll(Arrays.asList(
            "/doc.html",
            "/v3/api-docs/swagger-config",
            "/*/v3/api-docs/default",
            "/*/v3/api-docs",
            "/*/swagger-ui/**",
            "/webjars/**",
            "/favicon.ico",
            "/actuator/**"
        ));

        // 添加网关路由路径到排除列表，让GatewayFilter正常工作
        // 这些是Spring Cloud Gateway的路由配置，不是实际的服务端点
        excludeList.addAll(Arrays.asList(
            "/mall-auth/**",
            "/mall-admin/**",
            "/mall-portal/**",
            "/mall-search/**",
            "/mall-demo/**"
        ));

        return new SaReactorFilter()
                // 拦截地址：排除网关路由路径和服务白名单
                .addInclude("/**")
                .setExcludeList(excludeList)
                // 鉴权方法：每次访问进入
                .setAuth(obj -> {
                    // 对于OPTIONS预检请求直接放行
                    SaRouter.match(SaHttpMethod.OPTIONS).stop();

                    // 注意：由于排除了网关路由路径，这里不会匹配到网关路由
                    // 认证逻辑应该在各个微服务中实现，而不是在网关层面
                    // 这里只处理网关级别的通用认证（如API文档访问等）

                    // 如果需要网关级别的认证，可以在这里添加
                    // 例如：对管理后台的特殊路径进行认证
                })
                // setAuth方法异常处理
                .setError(this::handleException);
    }

    /**
     * 自定义异常处理
     */
    private CommonResult handleException(Throwable e) {
        //设置错误返回格式为JSON
        SaHolder.getResponse()
                .setHeader("Content-Type", "application/json; charset=utf-8")
                .setHeader("Access-Control-Allow-Origin", "*")
                .setHeader("Cache-Control", "no-cache");
        CommonResult result = null;
        if(e instanceof NotLoginException){
            result = CommonResult.unauthorized(null);
        }else if(e instanceof NotPermissionException){
            result = CommonResult.forbidden(null);
        }else{
            result = CommonResult.failed(e.getMessage());
        }
        return result;
    }
}

