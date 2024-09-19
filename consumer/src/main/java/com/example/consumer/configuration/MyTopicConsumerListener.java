package com.example.consumer.configuration;

import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class MyTopicConsumerListener {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "MyTopic", groupId = "kafka_id")
    public void listener(String value) {
        synchronized (messages) {
            messages.add(value);
        }
    }

}
