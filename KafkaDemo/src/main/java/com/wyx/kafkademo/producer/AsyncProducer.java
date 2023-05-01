package com.wyx.kafkademo.producer;

import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;


/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.controller
 * @Author: Origami
 * @Date: 2023/5/1 17:56
 */
// 测试同步发送与监听
// 通过超时设置，如果超过时间消息没有被接受，那么会报500，这样可以使得判断出消息是否被接收
@RestController
public class AsyncProducer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    //同步发送
    @GetMapping("/sync/{msg}")
    public void sync(@PathVariable("msg") String msg) throws Exception {
        //注意，可以设置等待时间，超出后，不再等候结果
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("msg", msg);
        SendResult<String, Object> result = future.get(3, TimeUnit.SECONDS);
        System.out.println(result);
    }

}
