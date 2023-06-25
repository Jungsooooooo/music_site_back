package com.music.restful.musicList.dto;

import com.music.restful.musicList.entity.MusicInfo;
import com.music.restful.user.entity.UserInfo;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MusicRecommendRequestDto {
	
	private String title;
	private String info;
	private Double recommended;
	private String genre;
	
	private String userUUID;
	
	private UserInfo userInfo;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public void setRecommended(Double recommended) {
		this.recommended = recommended;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setUserUUID(String userUid) {
		this.userUUID = userUid;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public MusicInfo toEntity() {
		MusicInfo musicInfo = new MusicInfo();
		
		musicInfo.setTitle(title);
		musicInfo.setInfo(info);
		musicInfo.setRecommended(recommended);
		musicInfo.setGenre(genre);
		
		return musicInfo;
	}
	
}
