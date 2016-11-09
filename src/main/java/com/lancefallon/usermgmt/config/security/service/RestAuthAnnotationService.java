package com.lancefallon.usermgmt.config.security.service;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import com.lancefallon.usermgmt.config.security.domain.CustomUserPasswordAuthenticationToken;

@Component("authService")
public class RestAuthAnnotationService {
	
	public Boolean isSelf(OAuth2Authentication auth, String username){
		if(auth == null){
			return false;
		}
		CustomUserPasswordAuthenticationToken token = (CustomUserPasswordAuthenticationToken) auth.getUserAuthentication();
		return username.equalsIgnoreCase(token.getUserPrivileges().getUsername());
	}
}
