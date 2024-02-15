package com.example.demo.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails{
	
	private final User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	/**
	 * アカウントの有効期限
	 * true 有効
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * アカウントのロック状態
	 * true ロックなし
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 資格情報（パスワード）の有効期限
	 * true 有効
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 有効なユーザか
	 * true 有効
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

}
