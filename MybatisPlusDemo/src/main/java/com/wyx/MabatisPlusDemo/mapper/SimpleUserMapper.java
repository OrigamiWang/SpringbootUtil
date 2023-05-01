package com.wyx.MabatisPlusDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyx.MabatisPlusDemo.entity.SimpleUser;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.mapper
 * @Author: Origami
 * @Date: 2023/5/1 11:46
 */
// Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
public interface SimpleUserMapper extends BaseMapper<SimpleUser> {
}
