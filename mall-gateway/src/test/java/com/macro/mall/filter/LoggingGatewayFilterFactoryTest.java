package com.macro.mall.filter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * LoggingGatewayFilterFactory测试类
 */
public class LoggingGatewayFilterFactoryTest {

    @Test
    public void testLoggingGatewayFilterFactoryCreation() {
        LoggingGatewayFilterFactory factory = new LoggingGatewayFilterFactory();

        // 测试默认配置
        LoggingGatewayFilterFactory.Config config = new LoggingGatewayFilterFactory.Config();
        var filter = factory.apply(config);

        assertThat(filter).isNotNull();
        assertThat(config.isPreLogger()).isTrue();
        assertThat(config.isPostLogger()).isTrue();
    }

    @Test
    public void testConfigSetters() {
        LoggingGatewayFilterFactory.Config config = new LoggingGatewayFilterFactory.Config();

        // 测试默认值
        assertThat(config.isPreLogger()).isTrue();
        assertThat(config.isPostLogger()).isTrue();

        // 测试setter方法
        config.setPreLogger(false).setPostLogger(false);

        assertThat(config.isPreLogger()).isFalse();
        assertThat(config.isPostLogger()).isFalse();
    }

    @Test
    public void testFilterWithCustomConfig() {
        LoggingGatewayFilterFactory factory = new LoggingGatewayFilterFactory();

        // 自定义配置
        LoggingGatewayFilterFactory.Config config = new LoggingGatewayFilterFactory.Config()
                .setPreLogger(true)
                .setPostLogger(false);

        var filter = factory.apply(config);

        assertThat(filter).isNotNull();
        assertThat(config.isPreLogger()).isTrue();
        assertThat(config.isPostLogger()).isFalse();
    }
}
