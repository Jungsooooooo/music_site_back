package com.music.restful.user.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.restful.common.SHA256;
import com.music.restful.user.dto.UserRequestDto;
import com.music.restful.user.entity.UserInfo;
import com.music.restful.user.repository.UserRepository;
import com.music.restful.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserInfo createUser(UserRequestDto userRequestDto) {
		
		UserInfo userInfo = userRequestDto.toEntity();
		
		SHA256 sha256 = new SHA256();
		
		try {
			userInfo.setPassword(sha256.encrypt(userRequestDto.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userInfo = userRepository.save(userInfo);
		return userInfo;
	}

	@Override
	public boolean existsById(String id) {
		return userRepository.existsById(id);
	}
	
	@Override
	public UserInfo loginUser(UserRequestDto userRequestDto) {
		
		SHA256 sha256 = new SHA256();
		
		String id = userRequestDto.getId();
		String password = null;
		try {
			password = sha256.encrypt(userRequestDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRepository.findByIdAndPassword(id, password );
	}
	
	@Override
	public List<UserInfo> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public UserInfo findId(UserRequestDto userRequestDto) {
		
		String name		= userRequestDto.getName();
		String email	= userRequestDto.getEmail();
		
		UserInfo userInfo = userRepository.findByEmailAndName(email, name);
		
		return userInfo;
	}
	
	@Override
	public UserInfo findPassword(UserRequestDto userRequestDto) {
		
		String id	 = userRequestDto.getId();
		String name	 = userRequestDto.getName();
		String email = userRequestDto.getEmail(); 
		
		UserInfo userInfo = userRepository.findByEmailAndNameAndId(email, name, id);
		
		return userInfo;
	}
	
	
}
