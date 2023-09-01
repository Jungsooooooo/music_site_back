package com.music.restful.musicList.service;

import java.util.List;

import com.music.restful.musicList.dto.MusicRecommendRequestDto;
import com.music.restful.musicList.entity.MusicInfo;

public interface MusicInfoService {
	
	public MusicInfo createMusicInfo(MusicRecommendRequestDto musicRecommendRequestDto);
	
	public List<MusicInfo> getAllMusicInfo();
}
