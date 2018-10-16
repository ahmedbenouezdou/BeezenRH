package com.beezen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.beezen.domain.Utilisateurs;
import com.beezen.service.IUtilisateursService;



@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private IUtilisateursService utilisateursService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateurs user = loadUtilisateurByUsername(username);

		String userAuths = user.getRoles().toString();
		userAuths = userAuths.substring(1, user.getRoles().toString().length() - 1);
		userAuths = userAuths.replaceAll(" ", "");
		List<GrantedAuthority> grantedAuths = AuthorityUtils.commaSeparatedStringToAuthorityList(userAuths);

		return new User(user.getLogin(), user.getMdp(), grantedAuths);
	}

	public Utilisateurs loadUtilisateurByUsername(String username) {

		return utilisateursService.getUtilisateurParLogin(username);
	}
}
