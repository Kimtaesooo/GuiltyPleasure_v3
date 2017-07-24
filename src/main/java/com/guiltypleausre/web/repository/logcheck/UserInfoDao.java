package com.guiltypleausre.web.repository.logcheck;

import com.guiltypleausre.web.domain.UserInfoDto;

public interface UserInfoDao {
	public UserInfoDto selectById(String u_id) throws Exception;
}
