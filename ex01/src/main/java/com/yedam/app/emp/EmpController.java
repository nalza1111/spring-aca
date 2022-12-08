package com.yedam.app.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {

	@Autowired EmpMapper empMapper;
	
	@GetMapping("/emp")
	public String emp(EmpVO vo, Model model) {
		model.addAttribute("emp", empMapper.getEmp(vo));
		return	"emp";
	}
}
