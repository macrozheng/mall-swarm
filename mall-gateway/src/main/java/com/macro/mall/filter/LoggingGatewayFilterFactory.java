package com.macro.mall.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

/**
 * 自定义日志网关过滤器工厂
 * 用于演示GatewayFilter和AbstractGatewayFilterFactory的功能
 */
@Component
public class LoggingGatewayFilterFactory extends AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    private static final Logger log = LoggerFactory.getLogger(LoggingGatewayFilterFactory.class);

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            log.info("LoggingGatewayFilter: Request to {} with method {}",
                    request.getPath(),
                    request.getMethod());

            if (config.isPreLogger()) {
                log.info("LoggingGatewayFilter Pre: Request headers: {}", request.getHeaders());
            }

            return chain.filter(exchange)
                    .doOnSuccess(aVoid -> {
                        if (config.isPostLogger()) {
                            log.info("LoggingGatewayFilter Post: Response status: {}",
                                    exchange.getResponse().getStatusCode());
                        }
                    })
                    .doOnError(throwable -> {
                        log.error("LoggingGatewayFilter Error: {}", throwable.getMessage());
                    });
        };
    }

    public static class Config {
        private boolean preLogger = true;
        private boolean postLogger = true;

        public boolean isPreLogger() {
            return preLogger;
        }

        public Config setPreLogger(boolean preLogger) {
            this.preLogger = preLogger;
            return this;
        }

        public boolean isPostLogger() {
            return postLogger;
        }

        public Config setPostLogger(boolean postLogger) {
            this.postLogger = postLogger;
            return this;
        }
    }
}
