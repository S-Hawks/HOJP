package com.example.signup_signing_spring_security.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
