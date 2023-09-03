package com.music.restful.user.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import com.music.restful.foundation.uuid.CommonUUID;
import com.music.restful.musicList.entity.MusicInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="user_info")
@Getter
public class UserInfo extends CommonUUID  {
	
	@Column
	private String id;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@Column
	private String zipCode;
	
	@Column
	private String phone;
	
	@Column
	private String email;
	
	@Column
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private LocalDateTime birth;
	
	@Column
	private String type;
	
//	@OneToMany(mappedBy = "userInfo", fetch=FetchType.LAZY)
//	private MusicInfo musicInfo;
	
	@Column
	private String role;

	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirth(LocalDateTime birth) {
		this.birth = birth;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode =zipCode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
