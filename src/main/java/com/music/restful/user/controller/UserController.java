package com.music.restful.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.restful.token.JwtTokenProvider;
import com.music.restful.user.dto.UserFindIdResponseDto;
import com.music.restful.user.dto.UserRequestDto;
import com.music.restful.user.dto.UserResponseDto;
import com.music.restful.user.entity.UserInfo;
import com.music.restful.user.service.UserService;


@Controller
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<?> getUser(){
		List<UserInfo> userInfo = userService.getAllUser();
		List<UserResponseDto> userResponseDto = userInfo.stream().map(user-> new UserResponseDto(user)).collect(Collectors.toList());
		 
		return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/login")
	   public ResponseEntity<?> login(@RequestBody UserRequestDto userRequestDto){
	      UserInfo userInfo = userService.loginUser(userRequestDto);
	    
	      if(userInfo != null) {
	         
//	         final String token = tokenProvider.create(userInfo);
	         UserResponseDto userResponseDto = new UserResponseDto(userInfo);
	         String token =   jwtTokenProvider.createToken(userResponseDto.getId(), userResponseDto.getName());
	         userResponseDto.setToken(token);
//	         UserResponseDto userResponseDto1 = UserResponseDto.builder().id(userInfo.getId()).token(token).build();
	      return ResponseEntity.ok(userResponseDto);
	      }
	      
	      return null;
	   }

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto){
		
		UserInfo userInfo = userService.createUser(userRequestDto);
		UserResponseDto userResponseDto = new UserResponseDto(userInfo);
		
		return new ResponseEntity<>(userResponseDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/check/{id}")
	public ResponseEntity<Boolean> checkUser(@PathVariable String id){
		
		return ResponseEntity.ok(userService.existsById(id));
	}
	
	@PostMapping("/findid")
	public ResponseEntity<?> findId(@RequestBody UserRequestDto userRequestDto){
		UserInfo userInfo	= userService.findId(userRequestDto);
		UserFindIdResponseDto userFindIdResponseDto = new UserFindIdResponseDto(userInfo);
		
		return new ResponseEntity<>(userFindIdResponseDto, HttpStatus.OK );
	}
	
}
