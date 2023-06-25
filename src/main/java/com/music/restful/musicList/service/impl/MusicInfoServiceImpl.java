package com.music.restful.musicList.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.restful.musicList.dto.MusicRecommendRequestDto;
import com.music.restful.musicList.entity.MusicInfo;
import com.music.restful.musicList.repository.MusicInfoRepository;
import com.music.restful.musicList.service.MusicInfoService;
import com.music.restful.user.entity.UserInfo;
import com.music.restful.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class MusicInfoServiceImpl implements MusicInfoService {
	
	@Autowired
	private MusicInfoRepository musicInfoRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public MusicInfo createMusicInfo(MusicRecommendRequestDto musicRecommendRequestDto) {
		
		MusicInfo musicInfo = musicRecommendRequestDto.toEntity();
		
		String uid = musicRecommendRequestDto.getUserUUID();
		UserInfo user = userRepository.findByUid(UUID.fromString(uid));
		
		musicInfo.setUserInfo(user);
		
		musicInfo = musicInfoRepository.save(musicInfo);
		
		return musicInfo;
	}

}
