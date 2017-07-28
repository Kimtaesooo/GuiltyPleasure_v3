package com.guiltypleausre.web.service.battlequiz;

import java.util.List;

import com.guiltypleausre.web.domain.Battle_Room;

public interface BattleQuizService {
	public void makeRoom(Battle_Room dto) throws Exception;
	public List<Battle_Room> getListRoom() throws Exception;
}
