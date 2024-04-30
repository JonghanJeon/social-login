package com.example.sociallogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.sociallogin.dto.KakaoTokenResponse;
import com.example.sociallogin.utils.KakaoToken;

@Service("kakaoLoginService")
public class KakaoLoginService implements SocialLoginService{

	//KAKAO
	@Value("${kakao.client.id}")
	private String KAKAO_CLIENT_ID;
	@Value("${kakao.client.secret}")
	private String KAKAO_CLIENT_SECRET;
	@Value("${kakao.client.url}")
	private String KAKAO_REDIRECT_URL;
	@Value("${kakao.parameter.body.grantType}")
	private String KAKAO_GRANT_TYPE;

	private final KakaoToken kakaoToken;

	@Autowired
	public KakaoLoginService(KakaoToken kakaoToken) {
		this.kakaoToken = kakaoToken;
	}

	@Override
	public String getSocialLogin() {
		return "redirect:https://kauth.kakao.com/oauth/authorize"
			+ "?response_type=code"
			+ "&client_id=" + KAKAO_CLIENT_ID
			+ "&redirect_uri=" + KAKAO_REDIRECT_URL;
	}

	@Override
	public KakaoTokenResponse getAccessToken(String code) {
		return kakaoToken.getToken(KAKAO_GRANT_TYPE, KAKAO_CLIENT_ID, KAKAO_REDIRECT_URL, code,
			KAKAO_CLIENT_SECRET);
	}
}
