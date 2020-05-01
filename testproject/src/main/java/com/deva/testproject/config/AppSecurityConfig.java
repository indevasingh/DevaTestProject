package com.deva.testproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
    public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		// To access h2-console from browser.
		http.headers().frameOptions().sameOrigin();
		
        http.authorizeRequests()
        	.antMatchers("/api/secured/**").hasRole("USER")
        	.antMatchers("/", "/api/**").permitAll()
        	.and().httpBasic();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
