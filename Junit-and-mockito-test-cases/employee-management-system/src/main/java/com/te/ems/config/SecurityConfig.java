package com.te.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		  http 
//          .csrf()
//          .disable()
//          .authorizeRequests()
////          .anyRequest()                                      // for all the api's
////          .antMatchers("/get-employee-details/**")           //for specific url 
//          .antMatchers("/get-employee-details/**").hasRole("ADMIN").anyRequest()  //for specific url and role
//          .fullyAuthenticated()
//          .and()
//          .httpBasic();
		http.cors().disable();
		http.csrf().disable()
		        .authorizeRequests().antMatchers("/**").authenticated().anyRequest().hasAnyRole("ADMIN").and()
//		        .authorizeRequests().antMatchers("/get-all-employee-details/**").authenticated().anyRequest()
//				.hasAnyRole("ADMIN").and()
//				.authorizeRequests().antMatchers("/get-employee-details/**").authenticated()
//				.anyRequest().hasRole("USER").and()
				.formLogin().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());

	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
