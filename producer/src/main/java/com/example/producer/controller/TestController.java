package com.example.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class TestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send_topic")
    public String sendTopic(@RequestParam String value) {
        kafkaTemplate.send("MyTopic", value);
        return "Сообщение опубликовано в топике";
    }
}
