package com.microservices.paymentservice.service.imp;

import com.microservices.paymentservice.model.Payment;
import com.microservices.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ControlService {
    private final PaymentRepository paymentRepository;
    private final KafkaProducerService kafkaProducerService;

    //Dakikada bir kontrol
    @Scheduled(cron = "0 * * * * *")
    public void fixedRate(){
        List<Payment> payments = paymentRepository.findByDate(LocalDateTime.now());
        System.out.println(payments.size());
        for(Payment payment : payments){
            kafkaProducerService.sendNotification(payment.getId()+"/"+payment.getUserId()+"/"+payment.getCorporationId());
        }
    }
}
