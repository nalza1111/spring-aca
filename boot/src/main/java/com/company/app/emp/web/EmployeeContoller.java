package com.company.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//controller는 component를 상속받아 컨테이너에 빈도만들고
//서블릿이 호출할 수 있도록 커맨드화
//@Component
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.app.common.Paging;
import com.company.app.emp.service.EmpService;
import com.company.app.emp.service.EmpVO;
@Controller
@RequestMapping("/emp")//공통된 매핑은 위로 뺄 수 있음
public class EmployeeContoller {
	
//	@Autowired EmpService empService;
//	//전체조회
//	@RequestMapping("empSelectAll")
//	public String empSelectAll(Model model) {//url명과 메소드명을 동일하게 주면 안헷갈림
//		model.addAttribute("emps",empService.getEmpAll(null));
//		return "empSelectAll";//pg명
//	}
	@Autowired EmpService empService;
	//전체조회 10개씩 조회
//	@RequestMapping("/empSelectAll")
//	public String empSelectAll(Model model, EmpVO vo, Integer page) {//url명과 메소드명을 동일하게 주면 안헷갈림
//		int pageSize = 10;
//		if (page != null) {
//			vo.setLast((page-1)*pageSize+1);
//			vo.setFirst(page*pageSize);
//		}
//		model.addAttribute("emps",empService.getEmpAll(vo));
//		return "emp/empSelectAll";//pg명
//	}
	//
	// 스프링부트에서 사용함 
	//전체조회
	@RequestMapping("/empSelectAll")
	public String empSelectAll(Model model, EmpVO vo, Paging paging) {
		paging.setPageUnit(3);
		model.addAttribute("emps",empService.getEmpAll(vo, paging)); 
		return "emp/empSelect";//pg명 뷰페이지이름
	}
	//단건조회
	@RequestMapping("/empSelect")
	public String empSelect(Model model, String id) {
		//request().getparameter 할 것없이 위에 String id
		model.addAttribute("emp",empService.getEmp(id));
		return "emp/emp"; //이건 타일즈에 등록안해놨기에 안뜸
	}
	
}
