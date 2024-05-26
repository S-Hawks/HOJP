package com.example.signup_signing_spring_security.service;

import com.example.signup_signing_spring_security.dto.UserDto;
import com.example.signup_signing_spring_security.entity.UserEntity;
import com.example.signup_signing_spring_security.repository.UserRepository;
import com.example.signup_signing_spring_security.shared.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final Utils utils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserDto createUser(UserDto userDto) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userDto, user);
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        //Public userId for user generate by util class(this method is use for to implement different approach to generate a user id)
        user.setUserId(utils.generateUserId(30));

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(user, returnValue);
        userRepository.save(user);
        return returnValue;
    }


    //This method is will invoke by
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
