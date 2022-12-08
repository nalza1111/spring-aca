package com.company.app.emp;

import java.util.List;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	String email;
	String hireDate;
	String jobId;
	String departmentId;
	String salary;
	
	List<String> employeeIds;
}
