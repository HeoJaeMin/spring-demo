package com.example.demo.user.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.application.UserInfoService;
import com.example.demo.user.domain.dto.LoginRequest;
import com.example.demo.user.domain.dto.SignupResponse;
import com.example.demo.user.domain.dto.UserPatchRequest;
import com.example.demo.user.domain.dto.UserResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @PutMapping
    public ResponseEntity<SignupResponse> signup(
        @RequestBody UserPatchRequest signupRequest
    ) {
        return ResponseEntity.ok(userInfoService.signup(signupRequest));
    }

    @PostMapping
    public ResponseEntity<UserResponse> login(
        @RequestBody LoginRequest signInRequest
    ) {
        return ResponseEntity.ok(userInfoService.login(signInRequest));
    }

    @PatchMapping
    public ResponseEntity<UserResponse> modify(
        @RequestBody UserPatchRequest modifyRequest
    ) {
        return null;
    }
}
