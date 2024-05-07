package com.example.demo.user.domain.dto;

import java.util.Objects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class UserPatchRequest {
    private String username;
    private String password;
    private String email;
    private String phone;

    public void validate() {
        if (Objects.isNull(username)) {
            throw new RuntimeException("Username is required");
        }

        if (Objects.isNull(password)) {
            throw new RuntimeException("Password is required");
        }

        if (Objects.isNull(email)) {
            throw new RuntimeException("Email is required");
        }

        if (Objects.isNull(phone)) {
            throw new RuntimeException("Phone is required");
        }
    }
}
