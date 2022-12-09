package com.company.app.dept.service;

import java.util.List;

public interface DeptService {
	List<DeptVO> getDeptAll();
	int insertDept(DeptVO vo);
}
