package com.kafkademo.chatapp.controllers;


import com.kafkademo.chatapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/kafka")
@CrossOrigin(origins = "*")
public class KafkaProducerController {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("publish")
    public String produce(@RequestParam("message") String message){
        KafkaProducerService kafkaProducer = new KafkaProducerService(kafkaTemplate);
        kafkaProducer.sendMessage(message);
        return message;

    }

}
