package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((requests) -> requests
						// 静的リソースファイルの設定
						.requestMatchers("/img/**", "/fonts/**", "/js/**", "/css/**").permitAll()
						.requestMatchers("/login", "/").permitAll()
						.requestMatchers("/manage/**").hasRole("MANAGE")
						.anyRequest().authenticated())
				.formLogin((form) -> form
						// ログインページへのパスを指定→コントローラーにもGET、/loginでの処理を記載する必要がある
						.loginPage("/login")
						// ログイン成功時に表示される画面へのパス
						.defaultSuccessUrl("/")
						.permitAll())
				.logout((logout) -> logout.permitAll());

		return http.build();
	}

}
