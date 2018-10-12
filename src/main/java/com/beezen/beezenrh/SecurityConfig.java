package com.beezen.beezenrh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomUserDetailsService customUserDetailsService;

	@Autowired
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {

		this.customUserDetailsService = customUserDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CorsConfiguration requestConfiguration = new CorsConfiguration().applyPermitDefaultValues();
		requestConfiguration.addAllowedMethod(CorsConfiguration.ALL);
		requestConfiguration.addAllowedHeader(CorsConfiguration.ALL);
		requestConfiguration.addExposedHeader("username");
		requestConfiguration.addExposedHeader("email");
		requestConfiguration.addExposedHeader("role");
	
		JWTAuthentificationFilter authFilter = new JWTAuthentificationFilter(super.authenticationManager(), customUserDetailsService);
		authFilter.setFilterProcessesUrl("/api/login");
		http.cors().configurationSource(request -> requestConfiguration).and().csrf().disable().authorizeRequests()
				.and().formLogin().loginPage("/api/login").permitAll().and()
				.addFilter(authFilter)
				.addFilter(new JWTAuthorizationFilter(super.authenticationManager(), customUserDetailsService))
				.headers().frameOptions().disable();
		
		http
        .authorizeRequests()
        .antMatchers("/api/index").permitAll();
	}

//	   @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        http
//	                .authorizeRequests()
//	                .antMatchers("/api/**").permitAll();
//	    }
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
