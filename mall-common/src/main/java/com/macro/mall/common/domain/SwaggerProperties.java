package com.macro.mall.common.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Swagger custom configuration
 * Created by macro on 2020/7/16.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class SwaggerProperties {
    /**
     * API document generation base path
     */
    private String apiBasePackage;
    /**
     * Whether to enable login authentication
     */
    private boolean enableSecurity;
    /**
     * Document title
     */
    private String title;
    /**
     * Document description
     */
    private String description;
    /**
     * Document version
     */
    private String version;
    /**
     * Document contact name
     */
    private String contactName;
    /**
     * Document contact URL
     */
    private String contactUrl;
    /**
     * Document contact email
     */
    private String contactEmail;
}
