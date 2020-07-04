package com.microservices.userservice.controller;

import com.microservices.common.model.user.UserRequestDto;
import com.microservices.common.model.user.UserResponseDto;
import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;
import com.microservices.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.save(userRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserResponseDto> get(@RequestParam String id){
        return new ResponseEntity<>( userService.getUser(id),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam String id){
        userService.deleteUser(id);
        return new ResponseEntity<>("\"User with id " + id + " has been deleted\"",HttpStatus.OK);
    }
}
