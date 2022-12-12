package co.yedam.prjt.dept.service;

import java.util.List;

public interface DeptService {
	//전체리스트
	List<DeptVO> getDeptAll();
	//생성
	int insertDept(DeptVO vo);
	//삭제
	int deleteDept(String departmentId);
	//업데이트
	int updateDept(DeptVO vo);
	//개별검색
	DeptVO getDept(String departmentId);
}
