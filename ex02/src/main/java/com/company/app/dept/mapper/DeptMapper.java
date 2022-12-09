package com.company.app.dept.mapper;

import java.util.List;

import com.company.app.dept.service.DeptVO;

public interface DeptMapper {
	List<DeptVO> getDeptAll();
	int insertDept(DeptVO vo);
}
