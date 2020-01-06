package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * oss上传文件的Callback结果
 * Created by macro on 2018/5/17.
 */
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
