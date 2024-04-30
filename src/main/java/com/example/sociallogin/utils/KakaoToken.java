package com.example.sociallogin.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sociallogin.dto.KakaoTokenResponse;

@FeignClient(name = "kakaoTokenClient", url = "https://kauth.kakao.com")
public interface KakaoToken {

	@RequestMapping(value = "/oauth/token", method = RequestMethod.POST, headers = "Content-type=application/x-www-form-urlencoded;charset=utf-8")
	KakaoTokenResponse getToken(
		@RequestParam("grant_type") String grantType,
		@RequestParam("client_id") String clientId,
		@RequestParam("redirect_uri") String redirectUri,
		@RequestParam("code") String code,
		@RequestParam("client_secret") String clientSecret);
}

