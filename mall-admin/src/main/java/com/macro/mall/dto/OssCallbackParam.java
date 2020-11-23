package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * callback parameters after oss upload is successful
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackParam {
    @ApiModelProperty("Requested callback address")
    private String callbackUrl;
    @ApiModelProperty("Callback is the parameter passed in the request")
    private String callbackBody;
    @ApiModelProperty("The format of the incoming parameters when callbacks, such as form submission")
    private String callbackBodyType;
}
