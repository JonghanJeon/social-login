package com.example.sociallogin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class KakaoTokenResponse {
	private String token_type; //토큰 타입, bearer로 고정
	private String access_token; //사용자 액세스 토큰 값
	private String refresh_token; // 사용자 리프레시 토큰 값
	private String expires_in; //액세스 토큰 만료 시간(초)
	private String refresh_token_expires_in; // 리프레시 토큰 만료 시간(초)
	private String scope;

	/**
	 * @return "Bearer " + access_token
	 */
	public String getAccessToken() {
		return "Bearer " + access_token;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("KakaoTokenResponse{");
		sb.append("token_type='").append(token_type).append('\'');
		sb.append(", access_token='").append(access_token).append('\'');
		sb.append(", refresh_token='").append(refresh_token).append('\'');
		sb.append(", expires_in='").append(expires_in).append('\'');
		sb.append(", refresh_token_expires_in='").append(refresh_token_expires_in).append('\'');
		sb.append(", scope='").append(scope).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
