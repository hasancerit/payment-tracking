package com.microservices.common.model.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequestDto {
    @NotBlank(message = "Fullname cannot be null." )
    private String fullname;

    @NotBlank(message = "Username cannot be null." )
    private String username;

    @NotBlank(message = "Password cannot be null." )
    private String password;
}
