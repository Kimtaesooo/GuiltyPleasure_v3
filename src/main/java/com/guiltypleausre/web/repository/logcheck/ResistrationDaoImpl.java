package com.guiltypleausre.web.repository.logcheck;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.guiltypleausre.web.domain.UserInfoDto;

@Repository
public class ResistrationDaoImpl implements ResistrationDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	private static final String namespace = "com.guiltypleasure.mappers.logcheck.registration-mapper";

	// 회원가입 등록
	@Override
	public void addUser(UserInfoDto userinfo) throws Exception {
		userinfo.setU_pw(bcrypt.encode(userinfo.getU_pw()));
		
		sqlSession.insert(namespace + ".addUser", userinfo);
		sqlSession.insert(namespace + ".u_poaA", userinfo);
		sqlSession.insert(namespace + ".u_poaB", userinfo);
		sqlSession.insert(namespace + ".u_poaC", userinfo);
		sqlSession.insert(namespace + ".u_poaD", userinfo);
		sqlSession.insert(namespace + ".u_battle", userinfo);
		sqlSession.insert(namespace + ".u_manage", userinfo);
		
		Object[] obj = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray();
		
		/*//권한 확인 ROLE_ANONYMOUS로 저장됨
		for(int i=0; i<obj.length; i++){
			System.out.println(obj[i]);
		}
		*/
		
		Map map = new HashMap();
		map.put("u_id", userinfo.getU_id());
		map.put("authority", obj[0].toString());
		sqlSession.insert(namespace + ".insertAuth", map);
	}
}
