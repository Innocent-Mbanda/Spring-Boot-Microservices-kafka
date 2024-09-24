package com.springKafkaWikimedia.Consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikiMediaTopicConfig {
    @Bean
    public NewTopic wikiMediaTopic(){
      return TopicBuilder.name("wiki-stream")
              .build();
    }
}
