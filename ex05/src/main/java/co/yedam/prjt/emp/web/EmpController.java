package co.yedam.prjt.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.yedam.prjt.common.Paging;
import co.yedam.prjt.emp.mapper.EmpMapper;
import co.yedam.prjt.emp.service.EmpService;
import co.yedam.prjt.emp.service.EmpVO;
import lombok.extern.log4j.Log4j;
@Log4j
@Controller //뷰넘기는 방식 3가지 : 보이드, 스트링, ModelAndView
@RequestMapping("/emp")
public class EmpController {
	@Autowired EmpService empService;
	@Autowired EmpMapper mapper; //시간상 서비스 등록안하고 바로 사용
	
	//등록페이지 이동
	@GetMapping("/insert")
	public void insert(Model model) {
		model.addAttribute("jobs", mapper.getJobs());
	} //void 리턴타입이면 자동으로 뷰페이지 매핑됨
	
	//등록처리
	@PostMapping("/insert") //겟,포스트 다르면 같은 경로 두개 쓸 수 있음
	public String insert(EmpVO vo, RedirectAttributes rttr) {
		empService.insertEmp(vo);
		//rttr.addAttribute("result","true");
		rttr.addFlashAttribute("result","등록완료"); //휘발새성 새로고침시 업음
		// return "/emp/list"; emp데이터 없이 가는 것이기 때문에 vo리스트를 같고 가야함
		//return "/emp/list"; //이상태에서 새로고침하면 입력을 한번 더 해버림
		 return "redirect:/emp/list";
	}
	
	//수정 페이지 이동
	@GetMapping("/update")
	public String update(Model model, @RequestParam String id) {
		//단건조회
		model.addAttribute("emp", empService.getEmp(id));
		model.addAttribute("jobs", mapper.getJobs());
		//단건조회 결과를 가져가야 함
		return "emp/update";
	}
	//수정 처리
	@PostMapping("/update")
	public String update(EmpVO vo, RedirectAttributes rttr) {
		empService.updateName(vo);
		log.info(vo);
		rttr.addFlashAttribute("result","수정완료");
		return "redirect:/emp/list";
	}
	//삭제 처리 >>포스트방식으로 하고싶으면 form태그안에 삭제버튼만들고 액션="딜리트"해줘야 함하고 form
	@GetMapping("/delete")
	public String delete(@RequestParam String id, RedirectAttributes rttr) {
		String result = empService.deleteEmp(id) + "건 삭제완료";
		rttr.addFlashAttribute("result", result);
		return "redirect:/emp/list";
	}
	//포스트방식 삭제
	@PostMapping("/delete")
	public String postDelete(@RequestParam String employeeId, RedirectAttributes rttr) {
		String result = empService.deleteEmp(employeeId) + "건 삭제완료";
		rttr.addFlashAttribute("result", result);
		return "redirect:/emp/list";
	}
	//전체조회 페이지
	@GetMapping("/list")
	public ModelAndView list(EmpVO vo, Paging paging) {
		ModelAndView mv = new ModelAndView("/emp/list");  //모델과 뷰를합친형태
		mv.setViewName("emp/list");//이렇게 세팅해도 됨
		mv.addObject("emps", empService.getEmpAll(vo, paging));
		return mv;
	}
	//단건조회 페이지 1)
	@GetMapping("/select")
	public String select(Model model, @RequestParam String empId) {
		model.addAttribute("emp",empService.getEmp(empId));
		return "emp/select";
	}
	//단건조회 페이지 2)
//	@GetMapping("/select/{empId}")
//	public String select(Model model, @PathVariable String empId) {
//		model.addAttribute(empService.getEmp(empId));
//		return "emp/select";
//	}
	
}
