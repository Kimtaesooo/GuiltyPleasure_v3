package com.guiltypleausre.web.service.logcheck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiltypleausre.web.domain.UserInfoDto;
import com.guiltypleausre.web.repository.logcheck.ResistrationDao;
import com.guiltypleausre.web.repository.logcheck.UserInfoDao;

@Service
public class LogCheckServiceImpl implements LogCheckService {
	
	@Autowired
	private ResistrationDao registDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	// 회원가입 멤버 추가
	@Override
	public void addUser(UserInfoDto regReq) throws Exception {
		registDao.addUser(regReq);
	}
	
	// 유저 정보 조회
	@Override
	public UserInfoDto selectById(String u_id) throws Exception {
		return userInfoDao.selectById(u_id);
	}

	// 유저 관리 조회
	@Override
	public UserInfoDto searchUserInfo(String u_id) throws Exception {
		return userInfoDao.searchUserInfo(u_id);
	}

	@Override
	public List<UserInfoDto> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
