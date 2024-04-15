package com.example.demo.user.application;

import com.example.demo.user.domain.component.UserFinder;
import com.example.demo.user.domain.component.UserManager;
import com.example.demo.user.domain.dto.SignupRequest;
import com.example.demo.user.domain.dto.SignupResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {

	private final UserManager userManager;
	private final UserFinder userFinder;

	public SignupResponse signup(SignupRequest request) {
		request.validate();
		userFinder.validateSignupRequest(request);
		return userManager.addUser(request);
	}
}
