package com.example.demo.user.domain.dto;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SignupRequestTest {

    @Test
    @DisplayName("username이 없으면 오류를 발생한다.")
    void validate() {
        SignupRequest signupRequest = SignupRequest.builder()
                .password("password")
                .email("email")
                .phone("phone")
                .build();

        Assertions.assertThrows(RuntimeException.class, signupRequest::validate);
    }

    @Test
    @DisplayName("password가 없으면 오류를 발생한다.")
    void validate2(){
        SignupRequest signupRequest = SignupRequest.builder().username("username")
                .email("email")
                .phone("phone")
                .build();

        Assertions.assertThrows(RuntimeException.class, signupRequest::validate);
    }

    @Test
    @DisplayName("email이 없으면 오류를 발생한다.")
    void validate3(){
        SignupRequest signupRequest = SignupRequest.builder().username("username")
                .password("password")
                .phone("phone")
                .build();

        Assertions.assertThrows(RuntimeException.class, signupRequest::validate);
    }

    @Test
    @DisplayName("pheon이 없으면 오류를 발생한다.")
    void validate4(){
        SignupRequest signupRequest = SignupRequest.builder().username("username")
                .password("password")
                .email("email")
                .build();

        Assertions.assertThrows(RuntimeException.class, signupRequest::validate);
    }

    @Test
    @DisplayName("위 경우 중 하나도 해당하지 않는다면 오류를 발생하지 않는다.")
    void validate5(){
        SignupRequest request = SignupRequest.builder()
                .username("username")
                .password("password")
                .email("email")
                .phone("phone")
                .build();

        Assertions.assertDoesNotThrow(request::validate);
    }

}
