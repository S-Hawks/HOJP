package com.faiaz.signup_signin.model;


public record SignUpRequestModel(
        String firstName,
        String lastName,
        String email,
        String password
)
{}
