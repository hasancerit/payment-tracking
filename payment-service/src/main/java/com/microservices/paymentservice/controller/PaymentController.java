package com.microservices.paymentservice.controller;

import com.microservices.common.model.payment.PaymentRequestDto;
import com.microservices.common.model.payment.PaymentResponseDto;
import com.microservices.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/task")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> save(@Valid @RequestBody PaymentRequestDto paymentRequestDto){
        return new ResponseEntity<>(paymentService.save(paymentRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PaymentResponseDto> get(@RequestParam String id){
        return new ResponseEntity<>(paymentService.get(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String id){
        paymentService.delete(id);
        return new ResponseEntity<>("\"User with id " + id + " has been deleted\"",HttpStatus.OK);
    }

    @DeleteMapping("/byuser")
    public ResponseEntity<String> deleteByUserId(@RequestParam String userId){
        paymentService.deleteByUserId(userId);
        return new ResponseEntity<>("\"Payment with UserId " + userId + " has been deleted\"",HttpStatus.OK);
    }

    /*
    private final KafkaProducerService kafkaProducerService;
    private final UserClient userClient;

    @GetMapping("/feigntest")
    public String test(@RequestParam String id){
        return userClient.getFeignTest(id);
    }

    @GetMapping("/kafkatest")
    public String testKafka(@RequestParam String msg){
        kafkaProducerService.sendMessage(msg);
        return "Gönderildi";
    }
   */
}
