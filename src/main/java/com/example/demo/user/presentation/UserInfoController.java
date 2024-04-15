package com.example.demo.user.presentation;

import com.example.demo.user.application.UserInfoService;
import com.example.demo.user.domain.dto.SignupRequest;
import com.example.demo.user.domain.dto.SignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {
	private final UserInfoService userInfoService;

	@PostMapping
	public ResponseEntity<SignupResponse> signup(
		@RequestBody
		SignupRequest signupRequest
	) {
		return ResponseEntity.ok(userInfoService.signup(signupRequest));
	}
}
