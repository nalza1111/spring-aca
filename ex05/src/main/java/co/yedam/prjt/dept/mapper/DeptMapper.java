package co.yedam.prjt.dept.mapper;

import java.util.List;

import co.yedam.prjt.dept.service.DeptVO;

public interface DeptMapper {
	//전체리스트
	List<DeptVO> getDeptAll(DeptVO vo);
	//생성
	int insertDept(DeptVO vo);
	//삭제
	int deleteDept(String departmentId);
	//업데이트
	int updateDept(DeptVO vo);
	//개별검색
	DeptVO getDept(String departmentId);
	
	int countDept(DeptVO vo);
}
