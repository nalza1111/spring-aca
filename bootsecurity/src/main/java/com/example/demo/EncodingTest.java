package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodingTest {
	
	@Test
	public void test() {
		//오른쪽 숫자로 암호화 하는 시간을 제어
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder(10);
		String pw = pe.encode("1234");
		System.out.println(pw);
		//암호화할 때 마다 다른 난수가 생성됨
		
		//패스워드 파라미터 암호화 == DB 패스워드;직접비교안됨 mathes메서드이용
		pe.matches("1234", pw);//이 함수를 이용해 디비와비교
		
	}
}
