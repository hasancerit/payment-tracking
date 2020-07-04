package com.microservices.userservice.service;

import com.microservices.common.model.user.UserRequestDto;
import com.microservices.common.model.user.UserResponseDto;

public interface UserService {
    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto getUser(String id);

    void deleteUser(String id);
}
