package com.springKafkaWikimedia.Producer.Producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@AllArgsConstructor
@Slf4j
public class WikiProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void wikiMediaProducerPublish(String message){
        log.info(format(" the message was published:: %", message));
        kafkaTemplate.send("wiki-stream", message);
    }
}
