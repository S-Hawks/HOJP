package com.faiaz.signup_signin.controller;

import com.faiaz.signup_signin.model.SignUpRequestModel;
import com.faiaz.signup_signin.model.SignUpResponseModel;
import com.faiaz.signup_signin.service.UserService;
import com.faiaz.signup_signin.utils.UserEndpointUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = UserEndpointUtil.signup, consumes = "application/json")
    public ResponseEntity<SignUpResponseModel> createUser(@RequestBody SignUpRequestModel signUpRequestModel) {
        return new ResponseEntity<>(userService.createUser(signUpRequestModel), HttpStatus.OK);
    }
}
