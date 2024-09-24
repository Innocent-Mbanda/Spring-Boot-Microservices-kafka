package com.springKafkaWikimedia.Producer.Controller;

import com.springKafkaWikimedia.Producer.Consumer.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wikimedia")
@RequiredArgsConstructor
public class WikiMidiaController {

    private final KafkaConsumer kafkaConsumer;

    @GetMapping
    public void startPublishing(){

        kafkaConsumer.consumeSteamAndPublish();
    }
}
