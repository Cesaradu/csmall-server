package com.gs.csmall.product.webapi.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.gs.csmall.product.webapi.mapper") // 如果无此配置，将无法自动装配Mapper对象
public class MybatisConfig {
}
