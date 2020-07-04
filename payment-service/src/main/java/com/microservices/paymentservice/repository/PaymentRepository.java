package com.microservices.paymentservice.repository;

import com.microservices.paymentservice.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment deleteByUserId(String userId);

    List<Payment> findByDate(LocalDateTime date);
}
