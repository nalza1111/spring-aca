package co.yedam.prjt.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.yedam.prjt.dept.mapper.DeptMapper;
import co.yedam.prjt.dept.service.DeptService;
import co.yedam.prjt.dept.service.DeptVO;
@Component
public class DeptServiceImpl implements DeptService {
	
	@Autowired DeptMapper deptMapper;
	
	@Override
	public int insertDept(DeptVO vo) {
		return deptMapper.insertDept(vo);
	}

	@Override
	public List<DeptVO> getDeptAll() {
		return deptMapper.getDeptAll();
	}

	@Override
	public int deleteDept(String departmentId) {
		return deptMapper.deleteDept(departmentId);
	}

	@Override
	public int updateDept(DeptVO vo) {
		return deptMapper.updateDept(vo);
	}

	@Override
	public DeptVO getDept(String departmentId) {
		return deptMapper.getDept(departmentId);
	}

}
