package com.faiaz.signup_signin.common.security;

import com.faiaz.signup_signin.common.SpringApplicationContext;
import com.faiaz.signup_signin.entity.UserEntity;
import com.faiaz.signup_signin.model.LoginRequestModel;
import com.faiaz.signup_signin.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            LoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(), LoginRequestModel.class);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.email(), creds.password(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        byte[] secretKeyBytes = Base64.getEncoder().encode(SecurityConstants.TOKEN_SECRET.getBytes());
        SecretKey secretKey = new SecretKeySpec(secretKeyBytes, "HmacSHA512");
        Instant now = Instant.now();

        String userName = ((User) auth.getPrincipal()).getUsername();
        String token = Jwts.builder()
                .subject(userName)
                .expiration(Date.from(now.plusMillis(SecurityConstants.EXPIRATION_TIME)))
                .issuedAt(Date.from(now))
                .signWith(secretKey)
                .compact();

        /* This line is very important line the thing is -> spring can perform dependency injection only on beans mean one class bean can be injected in another class bean
        but what if we don't want to create one class  bean. here ApplicationFilter is responsible for user login managed by spring security so it's not need to declare as spring bean,
        but we need userId which we can get from userService which is a spring bean. if this class is declared as Bean we can autowire "userService" and can get user easily.
        though "ApplicationFilter" Class is not a bean we can get userService By adding a helper class in my case the helper class is "SpringApplicationContext"
        POV: if class name is "UserServiceImpl" then the beanName need to be passed like "userServiceImpl" -> follow the code for better understanding
        ---> go to application context to learn more <---

        * */
        UserService userService = (UserService) SpringApplicationContext.getBean("userServiceImpl");
        UserEntity user = userService.getUser(userName);

        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
        res.addHeader("UserId", user.getUserId());

    }
}
