package com.example.demo.user.domain.entity;

import java.time.LocalDateTime;

import com.example.demo.user.domain.dto.SignupResponse;
import com.example.demo.user.domain.dto.UserPatchRequest;
import com.example.demo.user.domain.dto.UserResponse;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String password;
    private String email;
    private String phone;

    public static UserInfo consumeSignUpRequest(UserPatchRequest request) {
        return UserInfo.builder()
            .userName(request.getUsername())
            .password(request.getPassword())
            .email(request.getEmail())
            .phone(request.getPhone())
            .build();
    }

    public SignupResponse toSignupResponse() {
        return SignupResponse.builder().username(this.userName).email(this.email).phone(this.phone).build();
    }

    public UserResponse toSignInResponse() {
        return UserResponse.builder()
            .email(this.email)
            .phone(this.phone)
            .validateAt(LocalDateTime.now())
            .expireAt(LocalDateTime.now().plusHours(1L))
            .build();
    }

    public void consumeModify(UserPatchRequest request) {
        this.password = request.getPassword();
        this.email = request.getEmail();
        this.phone = request.getPhone();
    }
}
