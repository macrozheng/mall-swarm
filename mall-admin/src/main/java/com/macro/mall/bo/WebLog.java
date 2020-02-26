package com.macro.mall.bo;

import lombok.Data;

/**
 * Controller层的日志封装类
 * Created by macro on 2018/4/26.
 */
@Data
public class WebLog {
    private String description;
    private String username;
    private Long startTime;
    private Integer spendTime;
    private String basePath;
    private String uri;
    private String url;
    private String method;
    private String ip;
    private Object parameter;
    private Object result;
}
