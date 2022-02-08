package com.example.kakfatest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaSampleProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message) {
        System.out.println("send message : " + message);
        kafkaTemplate.send("ager", message);
    }
}