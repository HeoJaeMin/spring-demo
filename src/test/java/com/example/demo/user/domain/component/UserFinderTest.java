package com.example.demo.user.domain.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.dto.UserPatchRequest;

@SpringBootTest
@Transactional
class UserFinderTest {

    @Autowired
    private UserFinder userFinder;

    @Autowired
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager.addUser(UserPatchRequest.builder()
            .username("username")
            .password("password")
            .phone("phone")
            .email("email")
            .build());
    }

    @Test
    void validateSignupRequest() {
    }

    @Test
    void login() {
    }
}
