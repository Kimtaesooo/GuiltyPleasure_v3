package com.guiltypleausre.web.service.battlequiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiltypleausre.web.domain.Battle_Room;
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
	

}
