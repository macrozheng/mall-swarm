package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * callback parameters after oss upload is successful
 * Created by macro on 2018/5/17.
 */
public class OssCallbackParam {
    @ApiModelProperty("Requested callback address")
    private String callbackUrl;
    @ApiModelProperty("Callback is the parameter passed in the request")
    private String callbackBody;
    @ApiModelProperty("The format of the incoming parameters when callbacks, such as form submission")
    private String callbackBodyType;

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackBody() {
        return callbackBody;
    }

    public void setCallbackBody(String callbackBody) {
        this.callbackBody = callbackBody;
    }

    public String getCallbackBodyType() {
        return callbackBodyType;
    }

    public void setCallbackBodyType(String callbackBodyType) {
        this.callbackBodyType = callbackBodyType;
    }
}
