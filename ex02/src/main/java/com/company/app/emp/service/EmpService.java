package com.company.app.emp.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.company.app.common.Paging;


public interface EmpService {
	//전체조회
	public List<EmpVO> getEmpAll(EmpVO vo, Paging paging);
	//단건조회
	public EmpVO getEmp(String id);
	//등록
	public int insertEmp(EmpVO vo);
	//수정
	public int updateName(EmpVO vo);
	//삭제
	public int deleteEmp(String id);

	//트랜잭션 실험용
	
	public int addData(String data);
}
