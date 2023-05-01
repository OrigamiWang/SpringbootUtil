package com.wyx.MabatisPlusDemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyx.MabatisPlusDemo.entity.SimpleUser;
import com.wyx.MabatisPlusDemo.mapper.SimpleUserMapper;
import com.wyx.MabatisPlusDemo.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.controller
 * @Author: Origami
 * @Date: 2023/5/1 11:39
 */
@RestController
public class SimpleUserController {

    @Autowired
    private SimpleUserService simpleUserService;

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }


    @GetMapping("/user/{id}")
    public SimpleUser getSimpleUserById(@PathVariable("id") int id) {
        return simpleUserService.getUserById(id);
    }

    /**
     * Transactional 事物的原子性
     * RequestBody传递json
     * rollbackFor：发生任何异常都会回滚
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    @PostMapping("/add")
    public String insertSimpleUser(@RequestBody SimpleUser simpleUser) {
        try {
            simpleUserService.deleteById(2);
            simpleUserService.insert(simpleUser);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败！";
        }
        return "上传成功！";
    }


    @GetMapping("/page")
    public List<SimpleUser> testPage(@RequestParam("pageNum") int pageNum,
                                     @RequestParam("pageSize") int pageSize) {
        return simpleUserService.getUserPage(pageNum, pageSize);
    }

    @GetMapping("/condition")
    public List<SimpleUser> testPage() {
        QueryWrapper<SimpleUser> wrapper = new QueryWrapper<>();
        // 条件查询，
        // qu: username等于user1；
        // between: 介于1和10之间，闭区间
        // like: password like '%pswd%'
        wrapper.eq("username", "user1")
                .between("id", 1, 10)
                .like("password", "pswd");
        return simpleUserService.conditionalQuery(wrapper);
    }


}
