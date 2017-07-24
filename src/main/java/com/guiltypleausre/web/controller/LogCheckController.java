package com.guiltypleausre.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.guiltypleausre.web.domain.UserInfoDto;
import com.guiltypleausre.web.service.logcheck.LogCheckService;

/*	
 *  방식		URI								설명
 *  ---------------------------------------------------
 *  GET		/logCheck/GETlogin				로그인 페이지로 이동
 *  GET		/logCheck/GETlogoutpage			로그아웃 페이지로 이동
 *  GET		/logCheck/GETresistrationpage	회원가입 페이지로 이동
 *  GET		/logCheck/GETidpwpage			id,pw 찾기 페이지로 이동
 *  GET		/logCheck/GETlogoutpage			로그아웃 페이지로 이동
 *  GET		/logCheck/GETlogout				로그아웃 후 메인 페이지로 이동
 *  GET		/logCheck/GETidcheck			AJAX 아이디 유효성 검사
 *  POST	/logCheck/POSTaddUser			회원가입 등록
 *  POST	/logCheck/GETloginSuccess		로그인 성공
 *  GET		/logCheck/GETloginError			로그인 실패 페이지 이동
 */

/**
 * 회원가입, 로그인, id/pw 찾기  페이지에 대한 요청을 처리합니다.
 */
@Controller
@RequestMapping("/logCheck")
public class LogCheckController {
	private static final Logger logger = LoggerFactory.getLogger(LogCheckController.class);
	
	@Autowired
	LogCheckService logcheckservice;
	
	// 로그인 페이지 이동
	@RequestMapping(value = "/GETlogin")
	public String getLogin() {
		return "/login/login";
	}
	
	// security에서 로그인 요청을 하기 위해 만들어준 메서드
	@RequestMapping(value = "/check")
	public void check() {}
	
	// 로그아웃 페이지로 이동
	@RequestMapping(value = "/GETlogoutpage")
	public String getLogout() {
		return "/login/logout";
	}
	
	// 로그아웃 후 메인페이지로 이동
	@RequestMapping(value = "/GETlogout")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
	// id,pw 찾기 페이지로 이동
	@RequestMapping(value = "/GETidpwpage")
	public String getIdPwPage() {
		return "login/idpw";
	}
	
	
	@RequestMapping(value = "/GETloginSuccess")
	public String getLoginSuccess(Authentication id, HttpSession session){
		//System.out.println("id.getPrincipal().getName = : " + id.getName().toString());
		session.setAttribute("u_id", id.getName().toString());
		return "main";
	}
	
	// 로그인 에러 페이지 이동
	@RequestMapping(value = "/GETloginError")
	public String getLoginError() {
		return "/login/login_err";
	}
	
	// 로그아웃 페이지이동
	@RequestMapping(value = "/GETlogoutpage", method = RequestMethod.GET)
	public String getLogoutpage() {
		return "/login/logout";
	}
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "/GETresistrationpage", method = RequestMethod.GET)
	public String getResistrationpage() {
		return "/login/resistration";
	}
	
	// AJAX 아이디 유효성 검사
	@RequestMapping(value = "/GETidcheck", method = RequestMethod.GET)
	public String getIdCheck() {
		return "/login/idCheck";
	}
	
	// 회원가입 등록
	@RequestMapping(value = "/POSTaddUser", method = RequestMethod.POST)
	public String postAddUser(UserInfoDto regReq) throws Exception {
		logcheckservice.addUser(regReq);
		return "login/login_reg";
	}
}
