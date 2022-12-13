package com.company.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;

import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/*-context.xml")
public class EmpServiceClient {
	@Autowired EmpService empservice;
	//@Test
	public void getEmp() {
		EmpVO vo = empservice.getEmp("100");
		//log.info(vo);
	}
	//@Test
	public void deleteEmp() {
		String number = "100";
		if(empservice.deleteEmp(number)==99999) {
			log.info(number + "번 삭제불가");
		} else {
			log.info(number + "번 삭제완료");
		}
	}
	@Test
	public void addData() {
		empservice.addData("3555555555");
	}
}
