package com.microservices.paymentservice.service;


import com.microservices.common.model.payment.PaymentRequestDto;
import com.microservices.common.model.payment.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto save(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto get(String id);

    void delete(String id);

    void deleteByUserId(String userId);
}
