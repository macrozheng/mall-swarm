package com.macro.mall.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 简单的GatewayFilter实现
 * 用于演示直接实现GatewayFilter接口的方式
 */
@Component
public class SimpleLoggingFilter implements GatewayFilter {

    private static final Logger log = LoggerFactory.getLogger(SimpleLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("SimpleLoggingFilter: Processing request to {} with method {}",
                request.getPath(),
                request.getMethod());

        // 添加自定义header
        ServerHttpRequest modifiedRequest = request.mutate()
                .header("X-Gateway-Filtered", "true")
                .header("X-Request-Time", String.valueOf(System.currentTimeMillis()))
                .build();

        ServerWebExchange modifiedExchange = exchange.mutate()
                .request(modifiedRequest)
                .build();

        return chain.filter(modifiedExchange)
                .doOnSuccess(aVoid -> {
                    log.info("SimpleLoggingFilter: Request processed successfully");
                })
                .doOnError(throwable -> {
                    log.error("SimpleLoggingFilter: Request processing failed: {}", throwable.getMessage());
                });
    }
}
