package com.wyx.kafkademo.producer;

import jakarta.annotation.Resource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.controller
 * @Author: Origami
 * @Date: 2023/5/1 17:54
 */
// 异步生产者
// 不知道消息是否被消费者接收
@RestController
public class KafkaProducer {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 普通
    @GetMapping("/send/food/{msg}")
    public void sendMessage(@PathVariable("msg") String msg) {
        System.out.println("produce food...");
        kafkaTemplate.send("food", msg);
    }

    // 分区
    @GetMapping("/send/sport/{msg}")
    public void sendMsgByKey(@PathVariable("msg") String msg) {
        System.out.println("produce sport...");
        kafkaTemplate.send("sport", msg);
    }

}
