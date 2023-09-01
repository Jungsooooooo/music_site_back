package com.music.restful.musicList.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		return new ResponseEntity<>(musicRecommendResponseDto,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getMusicDataAll(){
		List<MusicInfo> musics = musicInfoService.getAllMusicInfo();
		List<MusicRecommendResponseDto> musicRecommendResponseDto = musics.stream().map(music-> new MusicRecommendResponseDto(music)).collect(Collectors.toList());		
		
		return new ResponseEntity<>(musicRecommendResponseDto,HttpStatus.OK);
	}
}
