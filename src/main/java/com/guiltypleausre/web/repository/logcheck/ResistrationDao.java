package com.guiltypleausre.web.repository.logcheck;

import com.guiltypleausre.web.domain.UserInfoDto;

public interface ResistrationDao {
	public void addUser(UserInfoDto regReq) throws Exception;
}
