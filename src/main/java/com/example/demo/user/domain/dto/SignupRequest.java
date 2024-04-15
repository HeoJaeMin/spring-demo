package com.example.demo.user.domain.dto;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class SignupRequest {
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
