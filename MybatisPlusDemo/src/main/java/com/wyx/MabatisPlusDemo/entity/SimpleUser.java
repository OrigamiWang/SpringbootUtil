package com.wyx.MabatisPlusDemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.entity
 * @Author: Origami
 * @Date: 2023/5/1 11:46
 */
@Data
@Builder
@TableName(value = "simple_user")
public class SimpleUser {
    private static final long serialVersionUID = -5644799954031156649L;
    @TableId(value = "id", type = IdType.AUTO)//指定自增策略
    private Integer id;
    private String username;
    private String password;
}
