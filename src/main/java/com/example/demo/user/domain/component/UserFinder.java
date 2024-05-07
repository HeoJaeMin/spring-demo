package com.example.demo.user.domain.component;

import com.example.demo.user.domain.dto.SignupRequest;
import com.example.demo.user.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserFinder {
	private final UserInfoRepository userInfoRepository;

	public void validateSignupRequest(SignupRequest request) {
		userInfoRepository
			.findByUserName(request.getUsername())
			.ifPresent(user -> {
				throw new RuntimeException("username already exists: [" + request.getUsername() + "]");
			});

		userInfoRepository
			.findByEmail(request.getEmail())
			.ifPresent(user -> {
				throw new RuntimeException("email already exists: [" + request.getEmail() + "]");
			});

		userInfoRepository
			.findByPhone(request.getPhone())
			.ifPresent(user -> {
				throw new RuntimeException("phone already exists: [" + request.getPhone() + "]");
			});
	}
}
