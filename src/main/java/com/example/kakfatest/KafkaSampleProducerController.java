package com.example.kakfatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaSampleProducerController {
    @Autowired
    private KafkaSampleProducerService kafkaSampleProducerService;

    @PostMapping(value = "/send")
    public void sendMessage(String message) {
        kafkaSampleProducerService.sendMessage(message);
    }
}