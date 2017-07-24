package com.guiltypleausre.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	private String username;
	private String password;

	public CustomUserDetails(String username, String password){
		super();
		this.username = username;
		this.password = password;
	}

	// 권한을 여러개를 가질 수 있기 때문에 list로 한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("CustomUserDetails");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// 권한은 문자열로 저장되지 않는다. 이렇게 객체에 담아서 저장한다.
		SimpleGrantedAuthority auth= new SimpleGrantedAuthority("ROLE_USER");
		authorities.add(auth);
		// authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
