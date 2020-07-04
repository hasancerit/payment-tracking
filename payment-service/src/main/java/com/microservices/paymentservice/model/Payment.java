package com.microservices.paymentservice.model;

import com.microservices.common.model.user.UserResponseDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Document(collection = "task")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Payment {
    @Id
    private String id;

    private String userId;
    private String corporationId;

    private String amount;
    private String currency; //Enum
    private LocalDateTime date;
    private boolean isPassed;
}
