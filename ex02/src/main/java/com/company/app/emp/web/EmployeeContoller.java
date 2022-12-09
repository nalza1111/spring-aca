package com.company.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//controller는 component를 상속받아 컨테이너에 빈도만들고
//서블릿이 호출할 수 있도록 커맨드화
//@Component
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;
@Controller
public class EmployeeContoller {
	
//	@Autowired EmpService empService;
//	//전체조회
//	@RequestMapping("empSelectAll")
//	public String empSelectAll(Model model) {//url명과 메소드명을 동일하게 주면 안헷갈림
//		model.addAttribute("emps",empService.getEmpAll(null));
//		return "empSelectAll";//pg명
//	}
	@Autowired EmpService empService;
	//전체조회
	@RequestMapping("empSelectAll")
	public String empSelectAll(Model model, EmpVO vo) {//url명과 메소드명을 동일하게 주면 안헷갈림
		model.addAttribute("emps",empService.getEmpAll(vo));
		return "empSelectAll";//pg명
	}
}
