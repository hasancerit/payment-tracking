package com.microservices.paymentservice.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendNotification(String msg) {
        kafkaTemplate.send("notification",msg);
    }
}
