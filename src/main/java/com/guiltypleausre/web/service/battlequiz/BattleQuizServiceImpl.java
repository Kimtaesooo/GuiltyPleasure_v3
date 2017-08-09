package com.guiltypleausre.web.service.battlequiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiltypleausre.web.domain.Battle_Play;
import com.guiltypleausre.web.domain.Battle_Room;
import com.guiltypleausre.web.domain.Quiz;
import com.guiltypleausre.web.repository.battlequizmodule.BattleQuizPlay;

@Service
public class BattleQuizServiceImpl implements BattleQuizService {
	
	@Autowired
	private BattleQuizPlay battleQuizPlay;
	
	@Override
	public void makeRoom(Battle_Room dto) throws Exception {
		battleQuizPlay.makeRoom(dto);
	}

	@Override
	public List<Battle_Room> getListRoom() throws Exception {
		return battleQuizPlay.getListRoom();
	}

	@Override
	public Quiz getQuiz(String q_type) throws Exception {
		return battleQuizPlay.getQuiz(q_type);
	}

	@Override
	public Battle_Play numPlayInfo(String br_num) throws Exception {
		return battleQuizPlay.numPlayInfo(br_num);
	}

	@Override
	public Battle_Room numRoomInfo(Battle_Room dto) throws Exception {
		return battleQuizPlay.numRoomInfo(dto);
	}

	@Override
	public void updatePlayRoom(String br_num, String u_id) throws Exception {
		battleQuizPlay.updatePlayRoom(br_num, u_id);
		
	}

	@Override
	public Battle_Room idRoomInfo(String u_id) throws Exception{
		return battleQuizPlay.idRoomInfo(u_id);	
	}

	@Override
	public String selectBattleRoomState(String br_num) throws Exception {
		return battleQuizPlay.selectBattleRoomState(br_num);
	}
	

}
