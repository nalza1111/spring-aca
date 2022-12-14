package com.company.app;

import com.company.app.emp.service.EmpVO;

public class CallTest {
	public static void main(String[] args) {
		int number = 20;
		change(number);
		System.out.println(number);
		
		EmpVO vo = new EmpVO();
		changeVO(vo);
		System.out.println(vo);
	}
	//call by value : 원시(primitive type)
	public static void change(int a) {
		a = 10;
	}
	//call by reference :참조
	public static void changeVO(EmpVO vo) {
		vo.setFirstName("길동");
	}
}
