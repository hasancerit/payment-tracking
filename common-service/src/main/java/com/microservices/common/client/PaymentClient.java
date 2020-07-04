package com.microservices.common.client;

import com.microservices.common.model.user.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "payment-service")
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.DELETE,path = "/task/byuser")
    void deleteByUserId(@RequestParam String userId);
}
