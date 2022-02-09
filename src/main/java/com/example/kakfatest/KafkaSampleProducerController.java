package com.example.kakfatest;

import com.example.kakfatest.config.KafkaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaSampleProducerController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestBody Message message) {
        log.info("Produce message : " + message.toString());
        message.setTimestamp(LocalDateTime.now().toString());
        try {
            kafkaTemplate.send("kafka-chat", message).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        return message;
    }
}