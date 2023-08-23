package com.music.restful.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.music.restful.token.PrincipalDetails;
import com.music.restful.user.entity.UserInfo;
import com.music.restful.user.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
	        UserInfo userInfo = userRepository.findById(id);
	        System.out.println("id : " + id);
	        if(userInfo != null) {
	            return new PrincipalDetails(userInfo);
	        }
	        return null;
	    }
}
