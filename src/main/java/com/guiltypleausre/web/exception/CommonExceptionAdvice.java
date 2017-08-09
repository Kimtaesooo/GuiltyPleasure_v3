package com.guiltypleausre.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// ControllerAdvice를 붙이면 모든 에러메세지는 이 클래스로 오게된다.
// 에러 발생 페이지는 error_common.jsp로 간다.
@ControllerAdvice
public class CommonExceptionAdvice {
	// 어떤 예외가 발생하냐에 따라 해당 메서드가 출력된다.
	
	
	// Exception 오류가 났을때(모든 예외)
	@ExceptionHandler(Exception.class)
	public ModelAndView common(Exception err){
		ModelAndView mav = new ModelAndView("main");
		mav.addObject("exception", err);
		return mav;
	}
}
