package com.guiltypleausre.web.service.logcheck;

import java.util.List;

import com.guiltypleausre.web.domain.UserInfoDto;

public interface LogCheckService {
	public void addUser(UserInfoDto regReq) throws Exception;
	public UserInfoDto selectById(String u_id) throws Exception;
	public List<UserInfoDto> selectAll() throws Exception;
}
