package com.music.restful.token;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.music.restful.user.entity.UserInfo;

public class PrincipalDetails implements UserDetails {
private static final long serialVersionUID = 1L;
	
	private UserInfo userInfo; // composition
	
	//일반로그인
	public PrincipalDetails(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	//해당 User의 권한을 리턴하는 곳 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			
			@Override
			public Role getAuthority() {
				return userInfo.getRole();
			}
		});
		return collect;
	}

	@Override
	public String getPassword() {
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		return userInfo.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		//계정이 만료되었는가?
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		//계정이 잠금상태인가?
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//계정 비밀번호가 몇일이 지났나?
		return true;
	}

	@Override
	public boolean isEnabled() {
		//계정이 활성화 되있나??
		return true;
	}
}
