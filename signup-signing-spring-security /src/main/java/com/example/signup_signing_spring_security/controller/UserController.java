package com.example.signup_signing_spring_security.controller;

import com.example.signup_signing_spring_security.dto.UserDto;
import com.example.signup_signing_spring_security.request.UserDetailsRequestModel;
import com.example.signup_signing_spring_security.response.UserResponseModel;
import com.example.signup_signing_spring_security.service.UserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUser(){
        return "get user called";
    }

    @PostMapping("/create")
    public UserResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserResponseModel userResponse = new UserResponseModel();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser, userResponse);
        return userResponse;
    }

    @PutMapping
    public String updateUser(){
        return "update user calling";
    }

    @DeleteMapping
    public String deleteUser(){
        return "delete mapping is calling";
    }

}
