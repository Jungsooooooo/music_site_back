package com.music.restful.user.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.music.restful.user.entity.UserInfo;
import com.music.restful.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository ;
	
	 @Override
	    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
	        UserInfo userInfo =  userRepository.findById(userId);
	        
	        return User.builder()
	        			.username(userInfo.getId())
	        			.password(userInfo.getPassword())
	        			.roles(userInfo.getRole())
	        			.build();
	    }

}
