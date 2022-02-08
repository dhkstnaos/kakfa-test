package com.example.kakfatest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaSampleConsumerService {
    @KafkaListener(topics = "ager", groupId = "agerChat")
    public void consume(String message) throws IOException {
        System.out.println("receive message : " + message);
    }
}
