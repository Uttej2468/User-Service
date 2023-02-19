//package com.dphone.userservice.security;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//
//		return new UserInfoUserDetailsService();
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		return http.csrf().disable()
//				.sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				.authorizeHttpRequests()
//				.requestMatchers("/adduser","/bower_components/*", "/.js",
//						"/*.jsx", "/main.css")
//				.permitAll()
//				.requestMatchers("/admin")
//				.hasAuthority("ROLE_ADMIN")
//				.requestMatchers("/user")
//				.hasAuthority("ROLE_USER")
//				.anyRequest().authenticated()
//				.and().formLogin()
////				.loginPage("/user/login")
////				.usernameParameter("userName")
////				.loginProcessingUrl("/user/login")
////				.and()
////				.logout()
////				.logoutUrl("/user/logout")
////				.logoutSuccessUrl("/user/login").and().exceptionHandling()
////				.accessDeniedPage("/accessDenied")
//				.and().build();
//		
//		//To redirect .successHandler(customSuccessHandler)
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService());
//		authenticationProvider.setPasswordEncoder(passwordEncoder());
//		return authenticationProvider;
//	}
//
//}