package com.yedam.app;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.EmpMapper;
import com.yedam.app.emp.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpMapperClient {

	@Autowired
	EmpMapper mapper;
	
	@Test
	public void empGetTest() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployee_id("100");
		EmpVO result = mapper.getEmp(empVO);
		System.out.println(result);
		assertEquals(result.getLast_name(), "King");
	}
}
