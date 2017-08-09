package com.guiltypleausre.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.guiltypleausre.web.domain.Battle_Room;
import com.guiltypleausre.web.service.battlequiz.BattleQuizService;

/*	
 *  방식		URI								설명
 *  ---------------------------------------------------
 *  GET		/battleQuiz/GETbattlepage		퀴즈 배틀 페이지로 이동
 *  POST	/battleQuiz/POSTmakeRoom		퀴즈 배틀 방 생성
 *  POST	/battleQuiz/POSTenterRoom		퀴즈 배틀 방 입장
 */

/**
 * 회원가입, 로그인, id/pw 찾기 페이지에 대한 요청을 처리합니다.
 */
@Controller
@RequestMapping("/battleQuiz")
public class BattleController {
	private static final Logger logger = LoggerFactory.getLogger(BattleController.class);

	@Autowired
	BattleQuizService battlequizservice;

	// 베틀 페이지 이동
	@RequestMapping(value = "/GETbattlepage")
	public ModelAndView getBattlePage() throws Exception {
		ModelAndView mav = new ModelAndView("/battle/battleRoom");
		mav.addObject("battleRoomList", battlequizservice.getListRoom());
		return mav;
	}

	// 베틀 방 생성
	@RequestMapping(value = "/POSTmakeRoom", method = RequestMethod.POST)
	public ModelAndView postMakeRoom(Battle_Room dto, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("battle/playRoom");
		String u_id = (String) session.getAttribute("u_id");
		dto.setU_id(u_id);
		battlequizservice.makeRoom(dto);
		mav.addObject("playRoomInfo", dto);
		return mav;
	}

	// 베틀 페이지 이동
	@RequestMapping(value = "/POSTenterRoom")
	public ModelAndView POSTenterRoom(Battle_Room dto, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("/battle/playRoom");
		battlequizservice.numRoomInfo(dto);
		/*
		if (battleroom.getBr_people() == 2) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('방이 꽉 찼습니다.!');");
			out.println("location.href = '/battleQuiz/GETbattlepage'");
			out.println("</script>");
			out.flush();
			out.close();
			return null;
		}
		*/
		
		if (dto.getBr_people() == 1) {
			battlequizservice.updatePlayRoom(dto.getBr_num(), dto.getU_id());
		}
		
		mav.addObject("playRoomInfo", dto);
		
		return mav;
	}

}
