package com.company.app.emp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	public EmpVO getEmp(String id);
	public int updateName(EmpVO vo);
	public int insertEmp(EmpVO vo);
	
	@Select("select * from departments")
	public List<Map<String, Object>> getDept();
	public List<Map<String, Object>> getDeptAll();
	public List<EmpVO> getEmpAll(EmpVO vo);
	public int count(EmpVO vo);
	
}
