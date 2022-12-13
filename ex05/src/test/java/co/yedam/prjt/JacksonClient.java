package co.yedam.prjt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.prjt.emp.mapper.EmpMapper;
import co.yedam.prjt.emp.service.EmpVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/*-context.xml")
@Log4j
public class JacksonClient {//잭슨은 어노테이션도 지원됨
	@Autowired EmpMapper empMapper;
	//@Test
	public void test2() throws JsonMappingException, JsonProcessingException {
		String str = "{\"employeeId\":\"100\",\"firstName\":\"홍길등\",\"lastName\":\"King\",\"email\":\"SKING\",\"hireDate\":866473200000,\"jobId\":\"AD_PRES\",\"departmentId\":\"90\",\"salary\":\"24000\",\"employeeIds\":null,\"first\":1,\"last\":10}";
		ObjectMapper om = new ObjectMapper();
		EmpVO vo = om.readValue(str, EmpVO.class); //== JSON.parse()
		log.info("###################"+vo.getHireDate());
	}
	@Test
	public void test1() {
		EmpVO vo = empMapper.getEmp("100");
		log.info(vo);
		ObjectMapper om = new ObjectMapper();
		try {
			String result = om.writeValueAsString(vo);
			log.info("###################"+result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
