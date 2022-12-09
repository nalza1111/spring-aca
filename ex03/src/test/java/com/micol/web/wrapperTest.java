package com.micol.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//원시(rpimtive type0 : int, long, char, float, double => 0으로 초기화
//1. 객체화 Integer, Long, Character, Float => 기본값이 null로 초기화
//2. 타입변환  string <-> int, long 할 때 사용함Integer.toString parseInt toString ...
//List<Object>
//List<Integer> int불가

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class wrapperTest {
	@Test
	public void test() {
		int a = new Integer(10); //팩, 객체로 만들어서 담아줘야하는데 버전9부터..
		Integer b = a; //자동 패킹됨
		String c = b.toString(); //스트링으로 변환
		a = Integer.parseInt(c); //스트링을 int로 변환
	}
	
}
