package com.macro.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis configuration class
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan("com.macro.mall.mapper")
public class MyBatisConfig {
}
