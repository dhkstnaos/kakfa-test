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

    //producer 부분
    @PostMapping(value = "/publish")
    public void sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now().toString());
        log.info("Produce message : " + message.toString());
        try {
            kafkaTemplate.send("kafka-chat", message).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //여기서 프론트엔드로 메시지를 전송합니다.
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        return message;
    }
}