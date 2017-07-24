package com.guiltypleausre.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.guiltypleausre.web.domain.UserInfoDto;
import com.guiltypleausre.web.service.logcheck.LogCheckService;


public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		System.out.println("CustomAuthenticationProvider authenticate");
		String u_id = (String) arg0.getPrincipal(); // principal이 ID를 의미한다.
		String u_pw = (String) arg0.getCredentials(); // credentials는 비밀번호를
														// 의미한다.

		LogCheckService logcheckservice = null;

		UserInfoDto dto;

		try {
			dto = logcheckservice.selectById(u_id);
			if (u_id.equals(dto.getU_id()) && u_pw.equals(dto.getU_pw())) {
				System.out.println("CustomAuthenticationProvider if문");
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				roles.add(new SimpleGrantedAuthority("ROLE_USER"));

				UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(u_id, u_pw, roles);

				result.setDetails(new CustomUserDetails(u_id, u_pw));
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// authenticate메서드보다 얘가 먼저 호출된다. false가 리턴되면 authenticate는 실행되지 않는다.
	@Override
	public boolean supports(Class<?> arg0) {
		// UsernamePasswordAuthenticationToken 유저의 정보를 가지고 있는 클래스. Test2에서
		// logger2번째 방법했던 거다.
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

}
