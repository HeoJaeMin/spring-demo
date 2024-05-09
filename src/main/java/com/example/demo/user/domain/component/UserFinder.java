package com.example.demo.user.domain.component;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.dto.LoginRequest;
import com.example.demo.user.domain.dto.UserPatchRequest;
import com.example.demo.user.domain.dto.UserResponse;
import com.example.demo.user.domain.entity.UserInfo;
import com.example.demo.user.domain.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFinder {
    private final UserInfoRepository userInfoRepository;

    public void checkUsernameUnique(UserPatchRequest request) {
        userInfoRepository.findByUserName(request.getUsername()).ifPresent(user -> {
            throw new RuntimeException("username already exists: [" + request.getUsername() + "]");
        });

    }

    public void checkEmailAndPhoneUnique(UserPatchRequest request) {
        userInfoRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new RuntimeException("email already exists: [" + request.getEmail() + "]");
        });

        userInfoRepository.findByPhone(request.getPhone()).ifPresent(user -> {
            throw new RuntimeException("phone already exists: [" + request.getPhone() + "]");
        });
    }

    public UserResponse login(LoginRequest request) {
        return userInfoRepository.findByUserNameAndPassword(
            request.getUsername(),
            request.getPassword()
        ).orElseThrow(() -> new RuntimeException("Invalid id or password")).toSignInResponse();
    }

    public UserInfo findByUserName(String userName) {
        return userInfoRepository.findByUserName(userName).orElseThrow();
    }
}
