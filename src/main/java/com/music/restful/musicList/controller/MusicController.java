package com.music.restful.musicList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.restful.musicList.dto.MusicRecommendRequestDto;
import com.music.restful.musicList.dto.MusicRecommendResponseDto;
import com.music.restful.musicList.entity.MusicInfo;
import com.music.restful.musicList.service.MusicInfoService;


@Controller
@RequestMapping("/api/musics")
public class MusicController {
	
	@Autowired
	private MusicInfoService musicInfoService;
	
	@PostMapping
	public ResponseEntity<?> musicRecoWrite(@RequestBody MusicRecommendRequestDto musicRecommendDto ){
		MusicInfo musicInfo = musicInfoService.createMusicInfo(musicRecommendDto);
		MusicRecommendResponseDto musicRecommendResponseDto = new MusicRecommendResponseDto(musicInfo);
		
		return new ResponseEntity<>(musicRecommendResponseDto,HttpStatus.OK);
	}
}