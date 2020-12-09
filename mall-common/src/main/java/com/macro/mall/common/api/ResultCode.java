package com.macro.mall.common.api;

/**
 * Enumerate some common API operation codes
 * Created by macro on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Successful operation"),
    FAILED(500, "operation failed"),
    VALIDATE_FAILED(404, "parameter check failed"),
    UNAUTHORIZED(401, "Not logged in or token has Expired"),
    FORBIDDEN(403, "No permissions");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
