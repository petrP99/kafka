package com.example.consumer.controller;

import com.example.consumer.configuration.MyTopicConsumerListener;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final MyTopicConsumerListener topic;

    @GetMapping("/get")
    public String getMessage() {
        List<String> messages = topic.getMessages();
        return messages.get(0);
    }
}
