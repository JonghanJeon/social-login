package com.example.sociallogin.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.sociallogin.dto.NaverTokenResponse;
import com.example.sociallogin.utils.NaverToken;

@Service("naverLoginService")
public class NaverLoginService implements SocialLoginService{

	//NAVER
	@Value("${naver.client.id}")
	private String NAVER_CLIENT_ID;
	@Value("${naver.client.secret}")
	private String NAVER_CLIENT_SECRET;
	@Value("${naver.client.url}")
	private String NAVER_REDIRECT_URL;
	@Value("${naver.client.state}")
	private String NAVER_CLIENT_STATE;

	private final NaverToken naverToken;

	@Autowired
	public NaverLoginService(NaverToken naverToken) {
		this.naverToken = naverToken;
	}

	@Override
	public String getSocialLogin() {
		return "redirect:https://nid.naver.com/oauth2.0/authorize"
		+ "?response_type=code"
		+ "&client_id=" + NAVER_CLIENT_ID
		+ "&redirect_uri=" + URLEncoder.encode(NAVER_REDIRECT_URL, StandardCharsets.UTF_8)
		+ "&state=" + URLEncoder.encode(NAVER_CLIENT_STATE, StandardCharsets.UTF_8);
	}

	@Override
	public NaverTokenResponse getAccessToken(String code) {
		return naverToken.getToken("authorization_code", NAVER_CLIENT_ID, NAVER_CLIENT_SECRET, code,
			URLEncoder.encode(NAVER_CLIENT_STATE, StandardCharsets.UTF_8));
	}
}
