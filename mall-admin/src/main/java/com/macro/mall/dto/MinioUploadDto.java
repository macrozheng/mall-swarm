package com.macro.mall.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * File Upload returns results
 * Created by macro on 2019/12/25.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinioUploadDto {
    private String url;
    private String name;
}
