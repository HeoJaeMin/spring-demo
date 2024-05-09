package com.example.demo.user.application;

import org.springframework.stereotype.Service;

import com.example.demo.user.domain.component.UserFinder;
import com.example.demo.user.domain.component.UserManager;
import com.example.demo.user.domain.dto.LoginRequest;
import com.example.demo.user.domain.dto.SignupResponse;
import com.example.demo.user.domain.dto.UserPatchRequest;
import com.example.demo.user.domain.dto.UserResponse;
import com.example.demo.user.domain.entity.UserInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserManager userManager;
    private final UserFinder userFinder;

    public SignupResponse signup(UserPatchRequest request) {
        request.validate();
        userFinder.validateSignupRequest(request);
        return userManager.addUser(request);
    }

    public UserResponse login(LoginRequest request) {
        request.validate();
        return userFinder.login(request);
    }

    public SignupResponse modifySet(UserPatchRequest request) {
        request.validate();
        userFinder.validateSignupRequest(request);
        UserInfo originUser = userFinder.findByUserName(request.getUsername());
        originUser.consumeModify(request);

        return userManager.modifyUser(originUser);
    }
}
