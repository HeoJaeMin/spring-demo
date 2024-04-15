package com.example.demo.user.domain.entity;

import com.example.demo.user.domain.dto.SignupRequest;
import com.example.demo.user.domain.dto.SignupResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@Entity
public class UserInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long userId;
	private String userName;
	private String password;
	private String email;
	private String phone;

	public static UserInfo consumeSignUpRequest(SignupRequest signupRequest) {
		return UserInfo
			.builder()
			.userName(signupRequest.getUsername())
			.password(signupRequest.getPassword())
			.email(signupRequest.getEmail())
			.phone(signupRequest.getPhone())
			.build();
	}

	public SignupResponse toSignupResponse() {
		return SignupResponse
			.builder()
			.username(this.userName)
			.email(this.email)
			.phone(this.phone)
			.build();
	}
}
