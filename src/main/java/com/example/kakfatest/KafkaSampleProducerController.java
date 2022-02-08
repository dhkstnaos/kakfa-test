package com.example.kakfatest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaSampleProducerController {

    private final KafkaSampleProducerService kafkaSampleProducerService;

    @PostMapping(value = "/send")
    public void sendMessage(String message) {
        kafkaSampleProducerService.sendMessage(message);
    }
}