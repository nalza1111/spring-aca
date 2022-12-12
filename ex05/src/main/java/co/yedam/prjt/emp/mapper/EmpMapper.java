package co.yedam.prjt.emp.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import co.yedam.prjt.emp.service.EmpVO;


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
	
	List<Map<String, Object>> getJobs();
}
