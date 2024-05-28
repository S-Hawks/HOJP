package com.faiaz.signup_signin.controller;

import com.faiaz.signup_signin.model.SignUpRequestModel;
import com.faiaz.signup_signin.model.SignUpResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseModel> signup(@RequestBody SignUpRequestModel signUpRequestModel){
        return null;
    }
}
