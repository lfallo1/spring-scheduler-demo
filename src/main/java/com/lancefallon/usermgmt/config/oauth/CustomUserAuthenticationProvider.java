package com.lancefallon.usermgmt.config.oauth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lancefallon.usermgmt.config.oauth.domain.UserPrivileges;

@Component("customUserAuthenticationProvider")
public class CustomUserAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOGGER = Logger.getLogger(CustomUserAuthenticationProvider.class);

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) {

		LOGGER.info("Inside #CustomUserAuthenticationProvider");

		CustomUserPasswordAuthenticationToken auth = null;
		if (authentication != null) {

			final Object adUserName = authentication.getPrincipal();
			
			// should check credentials here (for now just creating a bogus rule)
			if("lfallo1".equalsIgnoreCase(adUserName.toString())){				
				UserPrivileges user = new UserPrivileges();
				user.setAuthenticated(true);
				user.setDbList(Arrays.asList("default", "backup"));
				user.setUserID(1);
				user.setUserName(adUserName.toString());
				user.setDefaultDB("default");
				user.setPresentDB("default");
	
				// Adding the response to auth
				if (user.getUserID() != 0) {
					final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
					grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
					auth = new CustomUserPasswordAuthenticationToken(authentication.getPrincipal(),
							authentication.getCredentials(), grantedAuthorities);
					auth.setUserPrivileges(user);
				}
			}
		}
		
		return auth;
	}

	@Override
	public boolean supports(final Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class).isAssignableFrom(authentication);
	}

}
