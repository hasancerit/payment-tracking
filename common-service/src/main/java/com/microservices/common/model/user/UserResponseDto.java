package com.microservices.common.model.user;

import lombok.Data;

@Data
public class UserResponseDto {
    private String id;
    private String fullname;
    private String username;
    private String password;
}
