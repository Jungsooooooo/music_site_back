package com.music.restful.musicList.entity;

import com.music.restful.foundation.uuid.CommonUUID;
import com.music.restful.user.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;


@Entity
@Table(name = "music_info")
@Getter
public class MusicInfo extends CommonUUID {
		
	private String name;
	private String title;
	private String info;
	private String genre;
	private Double recommended;
	private String writer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="r_userInfo_uid")
	private UserInfo userInfo;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	public void setInfo(String Info) {
		this.info = Info;
	}
	
	public void setRecommended(Double recommended) {
		this.recommended = recommended;
	}

	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
