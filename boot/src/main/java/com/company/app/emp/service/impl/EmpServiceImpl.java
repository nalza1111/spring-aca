package com.company.app.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.common.Paging;
import com.company.app.emp.mapper.EmpMapper;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;

//@Component
//Component를 상속받아 빈등록, 트랜잭션 처리
@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired EmpMapper empMapper;
	
	@Override
	public List<EmpVO> getEmpAll(EmpVO vo, Paging paging) {
		//토탈페이지만 들어가면 paging객체의 모든 값이 계산됨
		paging.setTotalRecord(empMapper.count(vo));//first, start 계산
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		return empMapper.getEmpAll(vo);
	}

	@Override
	public EmpVO getEmp(String id) {
		return empMapper.getEmp(id);
	}

	@Override
	public int insertEmp(EmpVO vo) {
		return empMapper.insertEmp(vo);
	}

	@Override
	public int updateName(EmpVO vo) {
		return empMapper.updateName(vo);
	}

	@Override
	public int deleteEmp(String id) {
		// 100삭제 -> manager(참조)
		// 매니저인지 확인
		int result = empMapper.getManagerCheck(id);
		// 아니면 삭제
		if(result==0) {
			return empMapper.deleteEmp(id);
		} else {
			return 99999;
		}
	}

	@Override
	//@Transactional
	public int addData(String data) {
		empMapper.insert(data);
		empMapper.insert2(data);
		return 0;
	}

}
