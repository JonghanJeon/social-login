package com.example.sociallogin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NaverTokenResponse {
	private String access_token;
	private String refresh_token;
	private String token_type;
	private String expires_in;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("NaverTokenResponse{");
		sb.append("access_token='").append(access_token).append('\'');
		sb.append(", refresh_token='").append(refresh_token).append('\'');
		sb.append(", token_type='").append(token_type).append('\'');
		sb.append(", expires_in='").append(expires_in).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
