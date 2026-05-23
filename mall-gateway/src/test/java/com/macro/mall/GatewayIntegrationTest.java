package com.macro.mall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * 网关集成测试
 * 测试路由和过滤器功能
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("dev")
public class GatewayIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testGatewayRoutes() {
        // 测试路由是否正常工作
        webTestClient.get()
                .uri("/actuator/health")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP");
    }

    @Test
    public void testSwaggerAccess() {
        // 测试Swagger访问是否正常（在白名单中）
        webTestClient.get()
                .uri("/doc.html")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testStaticResources() {
        // 测试静态资源访问
        webTestClient.get()
                .uri("/webjars/springfox-swagger-ui/swagger-ui.css")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testKnife4jAccess() {
        // 测试Knife4j API文档访问
        webTestClient.get()
                .uri("/v3/api-docs/swagger-config")
                .exchange()
                .expectStatus().isOk();
    }

    // 注意：由于网关路由到实际的服务，而测试环境中服务可能不可用，
    // 这里主要测试网关本身的过滤器配置是否正确
    // 在实际部署环境中，这些路由应该能正常工作

    @Test
    public void testMallAuthRouteConfiguration() {
        // 这个测试验证路由配置是否存在
        // 由于没有实际的服务，我们只验证请求被正确路由（或返回错误）
        webTestClient.get()
                .uri("/mall-auth/test")
                .exchange()
                .expectStatus().is5xxServerError(); // 预期服务不可用错误
    }

    @Test
    public void testMallAdminRouteConfiguration() {
        webTestClient.get()
                .uri("/mall-admin/test")
                .exchange()
                .expectStatus().is5xxServerError(); // 预期服务不可用错误
    }

    @Test
    public void testMallPortalRouteConfiguration() {
        webTestClient.get()
                .uri("/mall-portal/test")
                .exchange()
                .expectStatus().is5xxServerError(); // 预期服务不可用错误
    }
}
