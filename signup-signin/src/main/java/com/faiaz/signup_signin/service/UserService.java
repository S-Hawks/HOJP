package com.faiaz.signup_signin.service;

import com.faiaz.signup_signin.entity.UserEntity;
import com.faiaz.signup_signin.model.SignUpRequestModel;
import com.faiaz.signup_signin.model.SignUpResponseModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    SignUpResponseModel createUser(SignUpRequestModel signUpRequestModel);

    UserEntity getUser(String email);
}
