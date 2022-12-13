package co.yedam.prjt.emp.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	//GET 메서드에서 Parameter로 받는 곳에서는 @DateTimeFormat을 쓰고,
	//RequestBody로 받는 곳에서만 @JsonFormat을 사용
    @JsonFormat(pattern = "MM-dd") 	//서버단에서 오는 데이터를 바꾸는 포맷(즉 json으로만들때)
	@DateTimeFormat(pattern = "yyyy-MM-dd") //클라이언트에서 오는 값을 담음
	Date hireDate;
    
	String jobId;
	String departmentId;
	String salary;
	
	@JsonIgnore //서버단에서 오는 데이터 무시
	List<String> employeeIds;
	@JsonIgnore
	Integer first = 1;
	@JsonIgnore
	Integer last = 10;
}
