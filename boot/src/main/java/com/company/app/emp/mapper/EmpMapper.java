package com.company.app.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.company.app.emp.service.EmpVO;


public interface EmpMapper  {
	EmpVO getEmp(String id);
	int updateName(EmpVO vo);
	int insertEmp(EmpVO vo);
	
	@Select("select * from departments")
	public List<Map<String, Object>> getDept();
	public List<Map<String, Object>> getDeptAll();
	List<EmpVO> getEmpAll(EmpVO vo);
	int count(EmpVO vo);
	
	//매니저여부 확인
	int getManagerCheck(String id);
	//삭제
	int deleteEmp(String id);

	//트랜잭션 실험용
	@Insert("insert into tbl_sample1 (col1) values (#{data})")
	public int insert(String data);
	@Insert("insert into tbl_sample2 (col1) values (#{data})")
	public int insert2(String data);
}
