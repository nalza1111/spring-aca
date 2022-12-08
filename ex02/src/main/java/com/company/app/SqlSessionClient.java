package com.company.app;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.app.emp.EmpMapper;
import com.company.app.emp.EmpVO;
@RunWith(SpringJUnit4ClassRunner.class)
//설정파일위치{"",""}여러개 넣을 수 있음 root의 sqlsession을 불러올거임
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SqlSessionClient {
	@Autowired SqlSession mybatis;
	@Autowired EmpMapper mapper;
	//@Test
	public void mapperSelect() {
		EmpVO vo = mapper.getEmp("100");
		System.out.println(vo);
	}
	@Test
	public void count() {
		EmpVO vo = new EmpVO();
		vo.setFirstName("A");
		int result = mapper.count(vo);
		System.out.println(result+"건 입니다.");
	}
	//@Test
	public void getEmpAll() {
		EmpVO vo = new EmpVO();
//		vo.setDepartmentId("30");
//		vo.setFirstName("A");
		vo.setEmployeeIds(Arrays.asList("100","101","102"));
		List<EmpVO> list = mapper.getEmpAll(vo);
		if(list != null) {
			list.forEach(emp -> System.out.println(emp.getFirstName()));
		}
		
	}
	//@Test
	public void insertEmp() {
		EmpVO vo = new EmpVO();
		//vo.setFirstName("춘향");		
		vo.setLastName("성");		
		vo.setEmail("메일");		
		vo.setHireDate("2022/12/08");		
		vo.setJobId("IT_PROG");
		int result = mapper.insertEmp(vo);
		System.out.println(result + "건이 등록됨");
	}
	//@Test 이것만 막으면 밑에 실행안됨
	public void select() {
		EmpVO vo = (EmpVO)(mybatis.selectOne("com.company.app.emp.EmpMapper.getEmp", "100"));
		System.out.println(vo);// 실행할 구문과 값
	}
	//@Test
	public void update() {
		EmpVO vo = new EmpVO();
		vo.setFirstName("홍길등");		
		vo.setEmployeeId("100");
		int result = mapper.updateName(vo);
		System.out.println(result + "건이 등록됨");
	}
	//@Test
	public void getDept() {
		//System.out.println(mapper.getDept().get(0).get("DEPARTMENT_NAME"));
		//부서명만 모두 출력
		mapper.getDept().forEach(dept -> System.out.println(dept.get("DEPARTMENT_NAME")));
	}
	//@Test
	public void getDeptAll() {
		mapper.getDeptAll().forEach(dept -> System.out.println(dept.get("departmentName")));
	}
}
