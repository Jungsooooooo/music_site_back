package com.music.restful.user.dto;

import java.util.UUID;

import com.music.restful.user.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDto  {
	private String id;
	private String address;
	private String phone;
	private String token;
	private String name;
	private UUID uid;
	
	public UserResponseDto(UserInfo userInfo) {
		super();
		this.id = userInfo.getId();
		this.address = userInfo.getAddress();
		this.phone = userInfo.getPhone();
		this.uid = userInfo.getUid();
		this.name = userInfo.getName();
	}

//	public String getId() {
//		return id;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public UUID getUid() {
//		return uid;
//	}
//
//	public String getToken() {
//		return token;
//	}
	
	
	

}
