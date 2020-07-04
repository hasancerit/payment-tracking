package com.microservices.userservice.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaListenerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListenerService.class);

//    @KafkaListener(topics = "top", groupId = "group1")
//    public void listen(String message,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        LOGGER.info("Received Messasge: " + message + " --  from group1-0 " + "from partition: " + partition);
//    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "top", partitions = { "0" }))
    public void listen(String message,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOGGER.info("Received Messasge: " + message + " --  from group1-0 " + "from partition: " + partition);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "top", partitions = { "1" }))
    public void listentwo(String message,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOGGER.info("Received Message: " + message + " --  from group1-1 " + "from partition: " + partition);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "top", partitions = { "2" }))
    public void listenthree(String message,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        LOGGER.info("Received Message: " + message + " --  from group1-2 " + "from partition: " + partition);
    }
}
