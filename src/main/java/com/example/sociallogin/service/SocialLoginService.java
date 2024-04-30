package com.example.sociallogin.service;

public interface SocialLoginService {
	String getSocialLogin();
	Object getAccessToken(String code);
}
