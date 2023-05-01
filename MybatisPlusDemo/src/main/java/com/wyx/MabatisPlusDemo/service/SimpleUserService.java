package com.wyx.MabatisPlusDemo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyx.MabatisPlusDemo.entity.SimpleUser;
import com.wyx.MabatisPlusDemo.mapper.SimpleUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: MybatisPlusDemo
 * @BelongsPackage: com.wyx.MabatisPlusDemo.service
 * @Author: Origami
 * @Date: 2023/5/1 16:39
 */
@Service
public class SimpleUserService {
    @Autowired
    private SimpleUserMapper simpleUserMapper;


    public SimpleUser getUserById(int id) {
        return simpleUserMapper.selectById(id);
    }

    public void deleteById(int id) {
        simpleUserMapper.deleteById(id);
    }

    public void insert(SimpleUser simpleUser) {
        simpleUserMapper.insert(simpleUser);
    }

    public List<SimpleUser> getUserPage(int pageNum, int pageSize) {
        IPage<SimpleUser> iPage = pageQuery(pageNum, pageSize);
        return iPage.getRecords();
    }

    /**
     * 分页查询（limit）
     */
    private IPage<SimpleUser> pageQuery(int pageNum, int pageSize) {
        Page<SimpleUser> page = new Page<>(pageNum, pageSize);
        return simpleUserMapper.selectPage(page, null);
    }

    /**
     * 条件查询（where）
     */
    public List<SimpleUser> conditionalQuery(QueryWrapper<SimpleUser> wrapper) {
        return simpleUserMapper.selectList(wrapper);
    }


}
