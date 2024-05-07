package com.example.demo.user.domain.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class LoginRequest {
    private String username;
    private String password;

    public void validate() {
        if (username == null) {
            throw new RuntimeException("아이디를 입력하세요.");
        }

        if (password == null) {
            throw new RuntimeException("비밀번호를 입력하세요.");
        }
    }
}
