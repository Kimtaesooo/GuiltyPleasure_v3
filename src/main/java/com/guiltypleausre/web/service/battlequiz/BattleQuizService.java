package com.guiltypleausre.web.service.battlequiz;

import java.util.List;

import com.guiltypleausre.web.domain.Battle_Play;
import com.guiltypleausre.web.domain.Battle_Room;
import com.guiltypleausre.web.domain.Quiz;

public interface BattleQuizService {
	public void makeRoom(Battle_Room dto) throws Exception;
	public List<Battle_Room> getListRoom() throws Exception;
	public Quiz getQuiz(String q_type) throws Exception;
	public Battle_Play numPlayInfo(String br_num) throws Exception;
	public Battle_Room numRoomInfo(Battle_Room dto) throws Exception;
	public void updatePlayRoom(String br_num, String u_id) throws Exception;
	public Battle_Room idRoomInfo(String u_id) throws Exception;
	public String selectBattleRoomState(String br_num) throws Exception;
}
