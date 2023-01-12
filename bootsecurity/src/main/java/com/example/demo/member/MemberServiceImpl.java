package com.example.demo.member;


import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


//UserDetailService	
public class MemberServiceImpl implements MemberService, UserDetailsService{

	@Override
	public MemberVO getMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO updateMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO insertMember() {
		// TODO Auto-generated method stub
		return null;
	}
	//UserDetailService	오버라이딩
	//시큐리티가 사용하는 userVO = UserDetails
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//username을 mapper단건조회
		//thorws 는 아이디가 없는경우?? 666쪽
		//DB에서 꺼내온 값이 vo에 담김
		MemberVO vo = MemberVO.builder().userid("choi") 
										.userpw("{bcrypt}$2a$16$pHK0a1Oh8RxtxuoERS3IfuVL4pyQCRJqlC.oNr1i95C6RAv8ub886")
										.auth(Arrays.asList("ROLE_USER","ROLE_ADMIN"))
										.build();
		return vo;
	}

	
}
