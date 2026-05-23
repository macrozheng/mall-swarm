package com.macro.mall.filter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * SimpleLoggingFilter测试类
 */
public class SimpleLoggingFilterTest {

    @Test
    public void testSimpleLoggingFilterCreation() {
        SimpleLoggingFilter filter = new SimpleLoggingFilter();

        assertThat(filter).isNotNull();
    }

    @Test
    public void testFilterImplementsGatewayFilter() {
        SimpleLoggingFilter filter = new SimpleLoggingFilter();

        // 验证实现了GatewayFilter接口
        assertThat(filter).isInstanceOf(org.springframework.cloud.gateway.filter.GatewayFilter.class);
    }
}