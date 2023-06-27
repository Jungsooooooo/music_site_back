 package com.music.restful.user.dto;

import com.music.restful.user.entity.UserInfo;

import lombok.Getter;

@Getter
public class UserFindIdResponseDto {
	
	String id;
	
	public UserFindIdResponseDto(UserInfo userInfo) {
		this.id = userInfo.getId();
	}
	
}
