package com.lancefallon.usermgmt.config.security.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lancefallon.usermgmt.config.security.domain.CustomUserPasswordAuthenticationToken;
import com.lancefallon.usermgmt.config.security.domain.UserPrivileges;

@Component("customUserAuthenticationProvider")
public class CustomUserAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	private static final Logger LOGGER = Logger.getLogger(CustomUserAuthenticationProvider.class);

	@Override
	@Transactional
	public Authentication authenticate(Authentication authentication) {

		LOGGER.info("Inside #CustomUserAuthenticationProvider");

		CustomUserPasswordAuthenticationToken auth = null;
		if (authentication != null) {

			final Object username = authentication.getPrincipal();
			final Object password = authentication.getCredentials();
			
			// should check credentials here (for now just creating a bogus rule)
			if(username != null){				
				UserPrivileges user = (UserPrivileges) userDetailsService.loadUserByUsername(username.toString());
	
				// Adding the response to auth
				if (user.getUserID() != 0) {
					auth = new CustomUserPasswordAuthenticationToken(authentication.getPrincipal(),
							authentication.getCredentials(), user.getAuthorities());
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
