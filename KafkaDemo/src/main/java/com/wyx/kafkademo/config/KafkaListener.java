package com.wyx.kafkademo.config;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.lang.Nullable;

/**
 * @BelongsProject: KafkaDemo
 * @BelongsPackage: com.wyx.kafkademo.config
 * @Author: Origami
 * @Date: 2023/5/1 18:07
 */
// 添加监听器，用于判断异步生产者发送的消息是否成功被消费者接收
// 如果成功，则进入onSuccess， 否则进入onError
// 另外，如果是因为kafka服务器宕机导致，不会进入onError，当服务器恢复正常，会进入onError
@Configuration
public class KafkaListener {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    //配置监听
    @PostConstruct
    private void listener() {
        kafkaTemplate.setProducerListener(new ProducerListener<String, Object>() {
            @Override
            public void onSuccess(ProducerRecord<String, Object> producerRecord, RecordMetadata recordMetadata) {
                System.out.println("onSuccess...");
                System.out.println(producerRecord.value());

            }

            @Override
            public void onError(ProducerRecord<String, Object> producerRecord,
                                @Nullable RecordMetadata recordMetadata, Exception exception) {
                System.out.println("onError...");
                System.out.println(producerRecord.value());
            }
        });
    }
}
