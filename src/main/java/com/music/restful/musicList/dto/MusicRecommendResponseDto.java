package com.music.restful.musicList.dto;

import java.util.UUID;

import com.music.restful.musicList.entity.MusicInfo;
import com.music.restful.user.entity.UserInfo;

import lombok.Getter;

@Getter
public class MusicRecommendResponseDto {
	
	private String title;
	private String info;
	private Double recommended;
	private String genre;
	
	private UserInfo userInfo;
	private UUID uid;

	public MusicRecommendResponseDto(MusicInfo musicInfo) {
		this.title =musicInfo.getTitle();
		this.info =musicInfo.getInfo();
		this.recommended =musicInfo.getRecommended();
		this.genre =musicInfo.getGenre();
		this.uid = musicInfo.getUid();
		
	}
	
}
