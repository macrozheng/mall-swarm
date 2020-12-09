package com.macro.mall.common.exception;

import com.macro.mall.common.api.IErrorCode;

/**
 * Assertion processing class, used to throw various API exceptions
 * Created by macro on 2020/2/27.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
