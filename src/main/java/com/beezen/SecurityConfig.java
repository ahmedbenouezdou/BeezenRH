package com.beezen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

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
	//	requestConfiguration.addExposedHeader("role");

//		 http.csrf().disable();
//
//	        http.cors().and()
//	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	                
//	                .and()
//	                .authorizeRequests()
//	                .antMatchers(HttpMethod.OPTIONS).permitAll();
	                
		JWTAuthentificationFilter authFilter = new JWTAuthentificationFilter(super.authenticationManager(), customUserDetailsService);
		authFilter.setFilterProcessesUrl("/login");
		
	

		http.cors().configurationSource(request -> requestConfiguration).and().csrf().disable().authorizeRequests()
				.and().formLogin().loginPage("/login").permitAll().and()
				.addFilter(authFilter)
				.addFilter(new JWTAuthorizationFilter(super.authenticationManager(), customUserDetailsService))
				.headers().frameOptions().disable();

		
		
//		http.cors().and().cors().configurationSource(request -> requestConfiguration)
//		.and().csrf().disable().authorizeRequests()
//		.antMatchers(HttpMethod.OPTIONS).permitAll()
//       // .antMatchers("/login").permitAll()
//        .anyRequest().authenticated()
//        .and().formLogin().loginPage("/api/login").permitAll()
//        .and().addFilter(authFilter)
//        .addFilter(new JWTAuthorizationFilter(super.authenticationManager(), customUserDetailsService))
//        .headers().frameOptions().disable()
//        // this disables session creation on Spring Security
//        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and().formLogin().disable();
//		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //pour un mot de passe crypté Md5Encoder() or BCryptPasswordEncoder()
		auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
