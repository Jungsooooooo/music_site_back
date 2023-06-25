package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.music.restful.MusicSiteApplication;
import com.music.restful.musicList.dto.MusicRecommendRequestDto;
import com.music.restful.musicList.entity.MusicInfo;
import com.music.restful.musicList.repository.MusicInfoRepository;

@SpringBootTest(classes = MusicSiteApplication.class)
class MusicSiteApplicationTests {
	@Autowired
	MusicInfoRepository musicMainRepository;
	
	@Autowired
	private MusicInfoRepository musicInfoRepository;

	@Test
	void contextLoads() {
		
		
	}
	
	@Test
	public MusicInfo createMusicInfo(MusicRecommendRequestDto musicRecommendRequestDto) {
		
		MusicInfo musicInfo = musicRecommendRequestDto.toEntity();
		
		musicInfo = musicInfoRepository.save(musicInfo);
		
		return musicInfo;
		
	}
	

}
