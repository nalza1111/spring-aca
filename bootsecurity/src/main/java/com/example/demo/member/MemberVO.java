package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO implements UserDetails{
	private String userid;
	private String userpw;
	private String tel;
	private String addr;
	List<String> auth;//String auth(권한이 한개..보직이 있을 수 도있으니
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		for(String at : auth) {
			list.add(new SimpleGrantedAuthority(at));
		}
		return list;
		//위의 다섯 줄과 같음
		//return auth.stream().map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList());
	}
	@Override
	public String getPassword() {
		return userpw;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userid;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		//이 아래로 리턴 트루로 바꿔주기
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
