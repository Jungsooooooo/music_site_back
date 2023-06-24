package com.music.restful.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.music.restful.user.entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserRequestDto {
	
	private String id;
	private String password;
	private String address;
	private String phone;
	private String name;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private LocalDateTime birth;
	
	private String email;
	private String zipCode;
	
	public UserRequestDto() {
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDateTime getBirth() {
		return birth;
	}
	
	public void setBirth(LocalDateTime birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}


	public UserInfo toEntity() {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setAddress(address);
		userInfo.setZipCode(address);
		userInfo.setPassword(password);
		userInfo.setPhone(phone);
		userInfo.setEmail(email);
		userInfo.setBirth(birth);
		userInfo.setName(name);
		
		return userInfo;
	}
	
	
}
