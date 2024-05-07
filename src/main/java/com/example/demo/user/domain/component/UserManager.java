package com.example.demo.user.domain.component;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.dto.SignupResponse;
import com.example.demo.user.domain.dto.UserPatchRequest;
import com.example.demo.user.domain.entity.UserInfo;
import com.example.demo.user.domain.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserManager {
    private final UserInfoRepository userInfoRepository;

    @Transactional
    public SignupResponse addUser(UserPatchRequest request) {
        return userInfoRepository.save(UserInfo.consumeSignUpRequest(request)).toSignupResponse();
    }
}
