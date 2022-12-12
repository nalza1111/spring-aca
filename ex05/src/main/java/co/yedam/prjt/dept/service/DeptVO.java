package co.yedam.prjt.dept.service;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DeptVO {
	String departmentId;
	String departmentName;
	String managerId;
	String locationId;
	
	List<String> departmentIds;
}
