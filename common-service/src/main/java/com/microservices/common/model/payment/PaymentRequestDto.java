package com.microservices.common.model.payment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.microservices.common.model.user.UserRequestDto;
import com.microservices.common.model.user.UserResponseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
public class PaymentRequestDto {
    private String userId;

    @NotBlank(message = "CorporationId cannot be null." )
    private String corporationId;

    @Pattern(regexp="[0-9]+",message = "Amount must have only numbers.")
    @NotBlank(message = "Amount cannot be null." )
    private String amount;

    @NotBlank(message = "Currency cannot be null." )
    private String currency; //Enum

    @NotNull(message = "PaymentDate cannot be null.")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private LocalDateTime date;
}
