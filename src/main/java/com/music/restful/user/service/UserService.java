package com.music.restful.user.service;

import java.util.List;

import com.music.restful.user.dto.UserRequestDto;
import com.music.restful.user.entity.UserInfo;


public interface UserService {

	public UserInfo createUser(UserRequestDto userRequestDto);
	
	public boolean existsById(String id); 
	
	public UserInfo loginUser(UserRequestDto userRequestDto);
	
	public List<UserInfo> getAllUser();
	
	public UserInfo findId(UserRequestDto userRequestDto);
	
	public UserInfo findPassword(UserRequestDto userRequestDto);
		
}
