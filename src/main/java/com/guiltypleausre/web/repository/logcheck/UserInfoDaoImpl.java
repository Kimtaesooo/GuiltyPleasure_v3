package com.guiltypleausre.web.repository.logcheck;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guiltypleausre.web.domain.UserInfoDto;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.guiltypleasure.mappers.logcheck.userinfo-mapper";

	@Override
	public UserInfoDto selectById(String u_id) throws Exception {
		return sqlSession.selectOne(namespace + ".selectById", u_id);
	}

}
