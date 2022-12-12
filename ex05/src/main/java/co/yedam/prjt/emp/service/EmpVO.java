package co.yedam.prjt.emp.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor //all생성자+no생성자 꼭 같이 쓰기
@Component
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;//utill
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date hireDate;
	String jobId;
	String departmentId;
	String salary;
	
	List<String> employeeIds;
	
	Integer first = 1;
	Integer last = 10;
}
