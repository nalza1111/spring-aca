package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.member.MemberVO;

public class BuildTest {
	@Test
	public void test() {
		//choi하나만 넣고 초기화
		MemberVO vo = MemberVO.builder()
							  .username("choi")
							  .build();
	}
	//memberVO패키지를 다른걸로 옮겨서 에러 뜰거임
}
