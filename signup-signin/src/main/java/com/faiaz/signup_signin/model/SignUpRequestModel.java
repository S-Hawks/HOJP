package com.faiaz.signup_signin.model;


import lombok.Getter;
import lombok.Setter;

public record SignUpRequestModel(

        String firstName,
        String lastName,
        String email,
        String password
)
{}
