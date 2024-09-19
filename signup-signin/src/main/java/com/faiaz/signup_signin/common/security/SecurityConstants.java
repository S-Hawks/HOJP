package com.faiaz.signup_signin.common.security;

import com.faiaz.signup_signin.common.SpringApplicationContext;
import org.springframework.core.env.Environment;


public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_SECRET = "etlkqd3DkXQ7ZtfvR4jZuGxlx516Q2lfWXXeTcxquiG3PmVcsbfBJOv00zUwPG6P";

    public static String getTokenSecret() {
        Environment environment = (Environment) SpringApplicationContext.getBean("environment");
        return environment.getProperty("token.secret");
    }
}
