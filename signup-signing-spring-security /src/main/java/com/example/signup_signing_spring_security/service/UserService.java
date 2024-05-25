package com.example.signup_signing_spring_security.service;

import com.example.signup_signing_spring_security.dto.UserDto;
import com.example.signup_signing_spring_security.entity.UserEntity;
import com.example.signup_signing_spring_security.repository.UserRepository;
import com.example.signup_signing_spring_security.shared.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Utils utils;


    public UserDto createUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userDto, user);
        user.setEncryptedPassword("test");

        //Public userId for user generate by util class(this method is use for to implement different approach
        user.setUserId(utils.generateUserId(30));

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(user, returnValue);
        userRepository.save(user);
        return returnValue;
    }
}
