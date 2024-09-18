package com.faiaz.signup_signin.service.impl;

import com.faiaz.signup_signin.entity.UserEntity;
import com.faiaz.signup_signin.model.SignUpRequestModel;
import com.faiaz.signup_signin.model.SignUpResponseModel;
import com.faiaz.signup_signin.repository.UserRepository;
import com.faiaz.signup_signin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private void isValidEmail(String email) {
        Pattern pattern = Pattern.compile(regexEmail, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }

    }


    @Override
    public SignUpResponseModel createUser(SignUpRequestModel signUpRequestModel) {
        isValidEmail(signUpRequestModel.email());

        if (userRepository.findUserEntitiesByEmail(signUpRequestModel.email()).isPresent())
            throw new RuntimeException("Record already found");
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(signUpRequestModel, user, signUpRequestModel.password());
        user.setPassword(bCryptPasswordEncoder.encode(signUpRequestModel.password()));

        String publicUserId = UUID.randomUUID().toString();
        user.setUserId(publicUserId);
        userRepository.save(user);
        return new SignUpResponseModel(publicUserId, signUpRequestModel.firstName(), signUpRequestModel.lastName(), signUpRequestModel.email());
    }

    @Override
    public UserEntity getUser(String email) {
        return userRepository.findUserEntitiesByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException("User with email " + email + " not found")
        );
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntitiesByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(username));

        return new User(username, userEntity.getPassword(), new ArrayList<>());
    }
}
