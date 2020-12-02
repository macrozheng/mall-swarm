package com.macro.mall.common.constant;

/**
 * Permission-related constant definition
 * Created by macro on 2020/6/19.
 */
public interface AuthConstant {

    /**
     * JWT storage permission prefix
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT storage permission attributes
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * Admin management client id
     */
    String ADMIN_CLIENT_ID = "admin-app";

    /**
     * Front mall client id
     */
    String PORTAL_CLIENT_ID = "portal-app";

    /**
     * Admin management interface path matching
     */
    String ADMIN_URL_PATTERN = "/mall-admin/**";

    /**
     * Redis cache permission rule key
     */
    String RESOURCE_ROLES_MAP_KEY = "auth:resourceRolesMap";

    /**
     * Authentication information Http request header
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT token prefix
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * User information Http request header
     */
    String USER_TOKEN_HEADER = "user";

}
