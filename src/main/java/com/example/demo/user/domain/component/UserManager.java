package com.example.demo.user.domain.component;

import com.example.demo.user.domain.dto.SignupRequest;
import com.example.demo.user.domain.dto.SignupResponse;
import com.example.demo.user.domain.entity.UserInfo;
import com.example.demo.user.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserManager {
	private final UserInfoRepository userInfoRepository;

	@Transactional
	public SignupResponse addUser(SignupRequest request) {
		return userInfoRepository
			.save(UserInfo.consumeSignUpRequest(request))
			.toSignupResponse();
	}
}
