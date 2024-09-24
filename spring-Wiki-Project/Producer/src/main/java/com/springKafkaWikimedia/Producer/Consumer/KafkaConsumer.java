package com.springKafkaWikimedia.Producer.Consumer;

import com.springKafkaWikimedia.Producer.Producer.WikiProducer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static java.lang.String.format;

@Service
@Slf4j

public class KafkaConsumer {
    private final WebClient webClient;
    private final WikiProducer wikiProducer;

    public KafkaConsumer(WebClient.Builder webClientBuilder, WikiProducer wikiProducer) {
        this.webClient = webClientBuilder.baseUrl("http://stream.wikimedia.org/v2")
                .build();
        this.wikiProducer = wikiProducer;
    }
    public void consumeSteamAndPublish(){
        webClient.get().uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikiProducer::wikiMediaProducerPublish);
    }
}

