package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Get OSS upload file authorization return result
 * Created by macro on 2018/5/17.
 */
public class OssPolicyResult {
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

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }
}
