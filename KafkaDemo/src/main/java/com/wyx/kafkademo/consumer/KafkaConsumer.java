package com.wyx.kafkademo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.component
 * @Author: Origami
 * @Date: 2023/5/1 18:19
 */
@Component
public class KafkaConsumer {

    //不指定group，默认取yml里配置的
    @KafkaListener(topics = {"food"})
    public void onMessageFood(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            System.out.println("consume food...");
            System.out.println("msg = " + msg);
        }
    }

    @KafkaListener(topics = {"sport"})
    public void onMessageSport(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> optional = Optional.ofNullable(consumerRecord.value());
        if (optional.isPresent()) {
            Object msg = optional.get();
            System.out.println("consume sport...");
            System.out.println("msg = " + msg);
        }
    }


}
