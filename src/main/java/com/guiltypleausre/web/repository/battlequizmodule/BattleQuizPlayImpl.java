package com.guiltypleausre.web.repository.battlequizmodule;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guiltypleausre.web.domain.Battle_Play;
import com.guiltypleausre.web.domain.Battle_Room;
import com.guiltypleausre.web.domain.Quiz;

@Repository
public class BattleQuizPlayImpl implements BattleQuizPlay {
	
	@Autowired
	private SqlSession sqlSession;
	
	Battle_Play battleplaydto = new Battle_Play();
	Battle_Room battleroomdto = new Battle_Room();

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

	@Override
	public Battle_Room idRoomInfo(String u_id) throws Exception {
		return sqlSession.selectOne(namespace + ".idRoomInfo");
	}
	
	@Override
	public Battle_Room numRoomInfo(Battle_Room dto) throws Exception {
		System.out.println("DAO numRoomInfo");
		System.out.println(dto.getBr_num());
		System.out.println(dto.getU_id());
		return sqlSession.selectOne(namespace + ".numRoomInfo");
	}

	@Override
	public String selectBattleRoomState(String br_num) throws Exception {
		String startFlag = sqlSession.selectOne(namespace + ".selectBattleRoomState");
		System.out.println(startFlag);
		if(startFlag.equals("N")){
			sqlSession.update(namespace + ".updateBattleRoomState");
		}
		return startFlag;
	}

	@Override
	public Battle_Play numPlayInfo(String br_num) throws Exception {
		Battle_Play roomdto = sqlSession.selectOne(namespace + ".numPlayInfo");
		return roomdto;
	}

	@Override
	public String checkanswer(String q_code) throws Exception {
		return sqlSession.selectOne(namespace + ".checkanswer");
	}

	@Override
	public void updatePlayRoomState(String br_num) throws Exception {
		sqlSession.update(namespace + ".updatePlayRoomState");
	}

	@Override
	public void updatePlayCnt(String br_num, String gameuser) throws Exception {
		battleplaydto = sqlSession.selectOne(namespace + ".numPlayInfo");
		String user01 = battleplaydto.getUser01();
		String user02 = battleplaydto.getUser02();
		if (gameuser.equals(user01)) {
			sqlSession.update(namespace + ".updatePlayCnt1");
		} else {
			sqlSession.update(namespace + ".updatePlayCnt2");
		}
		sqlSession.update(namespace + ".updatePlayCnt3");
	}

	@Override
	public void updatePlayCnt(String br_num) throws Exception {
		sqlSession.update(namespace + ".updatePlayCnt3");
	}

	@Override
	public Quiz getQuiz(String q_type) throws Exception {
		return sqlSession.selectOne(namespace + ".getQuiz");
	}

	@Override
	public void updatePlayRoom(String br_num, String u_id) throws Exception {
		sqlSession.update(namespace + ".updatePlayRoom");
		sqlSession.update(namespace + ".updateBattleRoom");
		
	}
}
