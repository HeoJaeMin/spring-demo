package com.example.demo.user.domain.component;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.dto.LoginRequest;
import com.example.demo.user.domain.dto.UserPatchRequest;
import com.example.demo.user.domain.dto.UserResponse;
import com.example.demo.user.domain.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFinder {
    private final UserInfoRepository userInfoRepository;

    public void validateSignupRequest(UserPatchRequest request) {
        userInfoRepository.findByUserName(request.getUsername()).ifPresent(user -> {
            throw new RuntimeException("username already exists: [" + request.getUsername() + "]");
        });

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
        ).orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 올바르지 않습니다.")).toSignInResponse();
    }
}
