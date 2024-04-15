package com.example.demo.user.domain.repository;

import com.example.demo.user.domain.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
	Optional<UserInfo> findByUserName(String userName);

	Optional<UserInfo> findByEmail(String email);

	Optional<UserInfo> findByPhone(String phone);
}
