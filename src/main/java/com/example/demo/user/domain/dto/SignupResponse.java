package com.example.demo.user.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class SignupResponse {
	private String username;
	private String email;
	private String phone;
}
