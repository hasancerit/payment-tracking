package com.microservices.paymentservice.service.imp;

import com.microservices.common.client.UserClient;
import com.microservices.common.model.payment.PaymentRequestDto;
import com.microservices.common.model.payment.PaymentResponseDto;
import com.microservices.common.model.user.UserResponseDto;
import com.microservices.paymentservice.model.Payment;
import com.microservices.paymentservice.repository.PaymentRepository;
import com.microservices.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserClient userClient;
    private final ModelMapper modelMapper;

    @Override
    public PaymentResponseDto save(PaymentRequestDto paymentRequestDto) {
        Payment payment = modelMapper.map(paymentRequestDto,Payment.class);
        payment = paymentRepository.save(payment);
        PaymentResponseDto paymentResponseDto = modelMapper.map(payment,PaymentResponseDto.class);
        return setUser(paymentResponseDto,payment.getUserId());
    }

    @Override
    public PaymentResponseDto get(String id) {
        Payment payment = paymentRepository.findById(id).get();
        PaymentResponseDto paymentResponseDto = modelMapper.map(payment,PaymentResponseDto.class);
        return setUser(paymentResponseDto,payment.getUserId());
    }

    @Override
    public void delete(String id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public void deleteByUserId(String userId) {
        paymentRepository.deleteByUserId(userId);
    }

    public PaymentResponseDto setUser(PaymentResponseDto paymentResponseDto,String id){
        paymentResponseDto.setUser(userClient.get(id).getBody());
        return paymentResponseDto;
    }
}
