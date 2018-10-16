package com.beezen;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.beezen.domain.Utilisateurs;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	private final CustomUserDetailsService customUserDetailsService;

	public JWTAuthentificationFilter(AuthenticationManager authenticationManager,
			CustomUserDetailsService customUserDetailsService) {

		this.authenticationManager = authenticationManager;
		this.customUserDetailsService = customUserDetailsService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			Utilisateurs user = new ObjectMapper().readValue(request.getInputStream(), Utilisateurs.class);

			return this.authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getMdp()));

		} catch (IOException e) {

			throw new RuntimeException(e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		User user = (User) authResult.getPrincipal();

		String token = Jwts.builder().setSubject(user.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET).compact();

		response.getWriter().write(SecurityConstants.TOKEN_PREFIX + token);
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);

		Utilisateurs utl = customUserDetailsService.loadUtilisateurByUsername(user.getUsername());
		response.addHeader("username", utl.getLogin());
		response.addHeader("email", utl.getEmail());
		response.addHeader("role", utl.getRoles().toString());

	}

}
