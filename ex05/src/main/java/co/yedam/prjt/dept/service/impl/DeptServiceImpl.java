package co.yedam.prjt.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.prjt.common.Paging;
import co.yedam.prjt.dept.mapper.DeptMapper;
import co.yedam.prjt.dept.service.DeptService;
import co.yedam.prjt.dept.service.DeptVO;
import co.yedam.prjt.emp.mapper.EmpMapper;
import co.yedam.prjt.emp.service.EmpVO;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	DeptMapper deptMapper;
	@Autowired
	EmpMapper empMapper;

	@Override
	public int insertDept(DeptVO vo) {
		return deptMapper.insertDept(vo);
	}

	@Override
	public List<DeptVO> getDeptAll(DeptVO vo, Paging paging) {
		paging.setTotalRecord(deptMapper.countDept(vo));
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		return deptMapper.getDeptAll(vo);
	}

	@Override
	public int deleteDept(String departmentId) {
		// employees 테이블에 있는지 확인
		EmpVO empVO = new EmpVO();
		empVO.setDepartmentId(departmentId);
		List<EmpVO> result = empMapper.getEmpAll(empVO);
		if (result.size() == 0) {
		// 아니면 삭제
			return deptMapper.deleteDept(departmentId);
		} else {
			return 99999;
		}
	}

	@Override
	public int updateDept(DeptVO vo) {
		return deptMapper.updateDept(vo);
	}

	@Override
	public DeptVO getDept(String departmentId) {
		return deptMapper.getDept(departmentId);
	}

	@Override
	public int count(DeptVO vo) {
		return deptMapper.countDept(vo);
	}

}
