package com.guiltypleausre.web.repository.battlequizmodule;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guiltypleausre.web.domain.Battle_Room;

@Repository
public class BattleQuizPlayImpl implements BattleQuizPlay {
	
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.guiltypleasure.mappers.battlequizplay-mapper";
	
	@Override
	public void makeRoom(Battle_Room dto) throws Exception {
		sqlSession.insert(namespace + ".makeRoom", dto);
		sqlSession.insert(namespace + ".playRoom", dto);
		
	}

	@Override
	public List<Battle_Room> getListRoom() throws Exception {
		return sqlSession.selectList(namespace + ".getListRoom");
	}

}
