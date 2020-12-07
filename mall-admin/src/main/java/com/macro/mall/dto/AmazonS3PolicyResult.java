package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Get S3 upload file authorization return result
 * Created by macro on 2018/5/17.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AmazonS3PolicyResult {
    @ApiModelProperty("User ID used in access authentication")
    private String accessKeyId;
    @ApiModelProperty("User form upload policy, string encoded by base64")
    private String policy;
    @ApiModelProperty("Strings signed on the policy")
    private String signature;
    @ApiModelProperty("Upload folder path prefix")
    private String dir;
    @ApiModelProperty("access domain for oss external services")
    private String host;
    @ApiModelProperty("Callback settings after successful upload")
    private String callback;
}
