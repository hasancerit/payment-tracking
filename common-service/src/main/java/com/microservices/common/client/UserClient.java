package com.microservices.common.client;

import com.microservices.common.model.user.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET,path = "/user")
    ResponseEntity<UserResponseDto> get(@RequestParam String id);
}
