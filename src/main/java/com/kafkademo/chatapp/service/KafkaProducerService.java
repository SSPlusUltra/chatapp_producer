package com.kafkademo.chatapp.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private  KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    public void sendMessage(String message){
        logger.info(String.format("message->%s",message));
        kafkaTemplate.send("chatapp_messages", message);
    }

}
