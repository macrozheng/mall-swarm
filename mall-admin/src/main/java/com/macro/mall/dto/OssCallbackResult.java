package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Callback result of oss uploaded file
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OssCallbackResult {
    @ApiModelProperty("file name")
    private String filename;
    @ApiModelProperty("File size")
    private String size;
    @ApiModelProperty("File mimeType")
    private String mimeType;
    @ApiModelProperty("The width of the picture file")
    private String width;
    @ApiModelProperty("The height of the picture file")
    private String height;
}
