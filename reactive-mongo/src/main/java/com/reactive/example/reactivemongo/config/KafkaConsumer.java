package com.reactive.example.reactivemongo.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class KafkaConsumer {
   // @KafkaListener(topics = {"ogriUser-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        log.info("KafkaConsumer : {} ", consumerRecord);

    }

}
