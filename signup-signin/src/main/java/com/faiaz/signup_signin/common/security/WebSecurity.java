package com.faiaz.signup_signin.common.security;

import com.faiaz.signup_signin.service.UserService;
import com.faiaz.signup_signin.utils.UserEndpointUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class WebSecurity {

    private final UserService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        AuthenticationManagerBuilder authenticationManagerBuilder =
//                http.getSharedObject(AuthenticationManagerBuilder.class);
//        authenticationManagerBuilder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//        return authenticationManagerBuilder.build();
//    }


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //Configure AuthenticationManagerBuilder
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        // Customize Login URL path
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager);
        authenticationFilter.setFilterProcessesUrl(UserEndpointUtil.login);

        http
                .csrf(AbstractHttpConfigurer::disable)  // Cleaner way to disable CSRF
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, UserEndpointUtil.signup).permitAll()  // Allow POST to signup endpoint
                        .anyRequest().authenticated())
                .authenticationManager(authenticationManager) //Here we need to define .authenticationManager because we create custom authenticationManager that's why we pass it to security
//                .addFilter(new AuthenticationFilter(authenticationManager)); //We are registering newly created AuthenticationManagerFilter to Security Object
                .addFilter(authenticationFilter); // If we don't use custom url then uncomment previous line and remove this line.
        return http.build();
    }

}
