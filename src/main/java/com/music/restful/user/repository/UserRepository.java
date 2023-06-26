package com.music.restful.user.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.restful.user.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, UUID> {
	
	boolean existsById(String id);
	
	UserInfo findByIdAndPassword(String id, String password);
	
	UserInfo findByUid(UUID uid);
	
	UserInfo findByEmailAndName(String email, String name);
	
	UserInfo findByEmailAndNameAndId(String email, String name, String id);
}
