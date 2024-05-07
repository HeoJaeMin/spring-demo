package com.example.demo.user.domain.dto;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class UserResponse {
    private String email;
    private String phone;
    private LocalDateTime validateAt;
    private LocalDateTime expireAt;
}
