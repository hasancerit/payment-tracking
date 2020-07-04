package com.microservices.userservice.service.imp;

import com.microservices.common.client.PaymentClient;
import com.microservices.common.model.user.UserRequestDto;
import com.microservices.common.model.user.UserResponseDto;
import com.microservices.userservice.model.User;
import com.microservices.userservice.repository.UserRepository;
import com.microservices.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PaymentClient paymentClient;

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto,User.class);
        user = userRepository.save(user);
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public UserResponseDto getUser(String id) {
        User user = userRepository.findById(id).get();
        return modelMapper.map(user,UserResponseDto.class);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
        paymentClient.deleteByUserId(id);
    }
}
