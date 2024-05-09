package com.example.demo.user.domain.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.user.domain.dto.UserPatchRequest;

@SpringBootTest
@Transactional
class UserFinderTest {

    private static final UserPatchRequest userPatchRequest = UserPatchRequest.builder()
        .username("username")
        .password("password")
        .phone("phone")
        .email("email")
        .build();
    @Autowired
    private UserFinder userFinder;
    @Autowired
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager.addUser(userPatchRequest);
    }

    @Test
    @DisplayName("username 중복 시 오류 발생")
    void test1() {
        Assertions.assertThrows(
            RuntimeException.class,
            () -> userFinder.checkUsernameUnique(UserPatchRequest.builder().username("username").build())
        );
    }

    @Test
    @DisplayName("username 중복 아닐경우 오류 발생하지 않음")
    void test2() {
        Assertions.assertDoesNotThrow(() -> userFinder.checkUsernameUnique(UserPatchRequest.builder()
            .username("another username")
            .build()));
    }

    @Test
    @DisplayName("email phone 둘 중 하나라도 중복일 경우 오류 발생")
    void test3() {
        Assertions.assertThrows(
            RuntimeException.class,
            () -> userFinder.checkEmailAndPhoneUnique(UserPatchRequest.builder().phone("phone").build())
        );

        Assertions.assertThrows(
            RuntimeException.class,
            () -> userFinder.checkEmailAndPhoneUnique(UserPatchRequest.builder().email("email").build())
        );
    }

    @Test
    @DisplayName("둘 다 중복이 아닐 경우 오류 발생하지 않음")
    void test4() {
        Assertions.assertDoesNotThrow(() -> userFinder.checkEmailAndPhoneUnique(UserPatchRequest.builder()
            .phone("123")
            .email("456")
            .build()));
    }

    @Test
    @DisplayName("아이디와 비밀번호가 모두 같은 데이터가 없을 경우 오류")
    void test5() {
        
    }
}
