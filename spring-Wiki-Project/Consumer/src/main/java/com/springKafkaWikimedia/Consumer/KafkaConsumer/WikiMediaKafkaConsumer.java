package com.springKafkaWikimedia.Consumer.KafkaConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikiMediaKafkaConsumer {

    @KafkaListener(topics = "wiki-stream", groupId = "myGroup")
    public void consumerMessage(String msg){

        log.info(String.format("consumed message", msg));
    }

}
