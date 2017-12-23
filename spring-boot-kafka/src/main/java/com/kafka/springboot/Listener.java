package com.kafka.springboot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {


    @KafkaListener(topics = {"send1"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("key : " + record.key());
        System.out.println("value : " + record.value());
    }
}