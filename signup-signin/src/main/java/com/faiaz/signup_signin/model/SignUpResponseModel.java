package com.faiaz.signup_signin.model;


public record SignUpResponseModel(
        String userId,
        String firstName,
        String lastName,
        String email
) {}
