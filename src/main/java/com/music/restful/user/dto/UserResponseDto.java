package com.music.restful.user.dto;

import java.util.UUID;

import com.music.restful.user.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class UserResponseDto  {
	private String id;
	private String address;
	private String phone;
	private String token;
	private String name;
	private UUID uuid;
	
	public UserResponseDto(UserInfo userInfo) {
		super();
		this.id = userInfo.getId();
		this.address = userInfo.getAddress();
		this.phone = userInfo.getPhone();
		this.name = userInfo.getName();
		this.uuid = userInfo.getUid();
	}
	
}
