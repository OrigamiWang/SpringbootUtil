package com.wyx.MabatisPlusDemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.config
 * @Author: Origami
 * @Date: 2023/5/1 14:14
 */
// 配置MyBatisPlusInterceptor，否则分页不生效
@Configuration
public class MyBatisPlusPageConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
