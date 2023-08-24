package com.music.restful.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private final JwtTokenProvider jwtTokenProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
        .antMatchers("/postgresql-console/**").permitAll();
	
		 http
         .httpBasic().disable() // rest api 만을 고려하여 기본 설정은 해제하겠습니다.
         .csrf().disable() // csrf 보안 토큰 disable처리.
         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 역시 사용하지 않습니다.
         .and()
         .authorizeRequests() // 요청에 대한 사용권한 체크
         .antMatchers("/api/user/**").permitAll()
         .antMatchers("/api/musics").hasRole("USER")
         .anyRequest().permitAll() // 그외 나머지 요청은 누구나 접근 가능
         .and()
         .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                 UsernamePasswordAuthenticationFilter.class)
         .authorizeRequests(); // 권한요청 처리 설정 메서드
		

	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
