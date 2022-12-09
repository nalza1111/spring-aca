package com.company.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.dept.service.DeptService;
import com.company.app.dept.service.DeptVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DeptServiceClinet {
	
	@Autowired DeptService deptsevice;
	
	//@Test
	public void insertDept() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentName("blueShark");
		log.info(deptsevice.insertDept(vo));
	}
	//@Test
	public void getDeptAll() {
		log.info(deptsevice.getDeptAll());
	}
}
