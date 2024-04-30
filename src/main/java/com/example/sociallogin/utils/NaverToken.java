package com.example.sociallogin.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sociallogin.dto.NaverTokenResponse;

@FeignClient(name = "NaverTokenFeign", url = "https://nid.naver.com")
public interface NaverToken {

	/**
	 * 접근 토큰 발급 메서드
	 * @param grantType
	 * @param clientId
	 * @param clientSecret
	 * @param code
	 * @param state
	 * @return NaverTokenResponse
	 */
	@GetMapping(value = "/oauth2.0/token")
	NaverTokenResponse getToken(
		@RequestParam("grant_type") String grantType,
		@RequestParam("client_id") String clientId,
		@RequestParam("client_secret") String clientSecret,
		@RequestParam("code") String code,
		@RequestParam("state") String state
	);
}
