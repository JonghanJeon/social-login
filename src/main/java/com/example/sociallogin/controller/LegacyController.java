package com.example.sociallogin.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.sociallogin.dto.NaverTokenResponse;
import com.example.sociallogin.dto.KakaoTokenResponse;
import com.example.sociallogin.service.SocialLoginService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/legacy/login")
public class LegacyController {

	private final SocialLoginService kakaoLoginService;
	private final SocialLoginService naverLoginService;

	@Autowired
	public LegacyController(@Qualifier("kakaoLoginService") SocialLoginService kakaoLoginService,
		@Qualifier("naverLoginService") SocialLoginService naverLoginService) {
		this.kakaoLoginService = kakaoLoginService;
		this.naverLoginService = naverLoginService;
	}

	@GetMapping
	public String callSocialLogin(
		@RequestParam("logintype") String type
	) throws UnsupportedEncodingException {
		if (type.equals("kakao")) {
			log.info("KAKAO LOGIN 시도");
			return kakaoLoginService.getSocialLogin();
		} else if (type.equals("naver")) {
			log.info("NAVER LOGIN 시도");
			return naverLoginService.getSocialLogin();
		}
		return "error";
	}

	@ResponseBody
	@GetMapping("/kakao/redirect")
	public String redirectKakao(
		@RequestParam("code") String code
	) {
		log.info("인가 코드 발급 성공 : code=" + code);
		log.info("토큰 발급 시작");
		KakaoTokenResponse accessToken = (KakaoTokenResponse)kakaoLoginService.getAccessToken(code);
		log.info("토큰 발급 완료");
		return accessToken.toString();
	}

	@ResponseBody
	@GetMapping("/naver/redirect")
	public String redirectNaver(
		@RequestParam("code") String code,
		@RequestParam("state") String state
	) {
		log.info("인가 코드 발급 성공 : code=" + code);
		log.info("토큰 발급 시작");
		NaverTokenResponse accessToken = (NaverTokenResponse)naverLoginService.getAccessToken(code);
		log.info("토큰 발급 완료");
		return accessToken.toString();
	}


}
