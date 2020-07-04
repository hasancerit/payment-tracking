package com.microservices.common.model.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.common.model.user.UserResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentResponseDto {
    private String id;

    private UserResponseDto user;
    private String corporationId;

    private String amount;
    private String currency; //Enum
//    @JsonFormat(pattern="dd-MM-yyyy hh:mm")
    private LocalDateTime date;
    private boolean isPassed;
}
