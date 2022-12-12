package co.yedam.prjt.dept.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.yedam.prjt.common.Paging;
import co.yedam.prjt.dept.service.DeptService;
import co.yedam.prjt.dept.service.DeptVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired DeptService deptService;
	
	//등록 페이지로 이동
	@GetMapping("/insert")
	public void insert(Model model) {}
	//등록 처리
	@PostMapping("/insert")
	public String insert(DeptVO vo, RedirectAttributes rttr) {
		int result = deptService.insertDept(vo);
		if (result > 0) {
			rttr.addFlashAttribute("result", "등록완료");
		} else {
			rttr.addFlashAttribute("result", "등록실패");
		}
		return "redirect:/dept/list";
	}
	//수정 페이지로 이동
	@GetMapping("/update")
	public String update(Model model, @RequestParam String departmentId) {
		model.addAttribute("dept", deptService.getDept(departmentId));
		return "dept/update";
	}
	//수정처리
	@PostMapping("/update")
	public String update(DeptVO vo, RedirectAttributes rttr) {
		deptService.updateDept(vo);
		rttr.addFlashAttribute("result", "수정완료");
		return "redirect:/dept/list";
	}
	
	//삭제 처리
	@PostMapping("/delete")
	public String delete(@RequestParam String departmentId, RedirectAttributes rttr) {
		int result = deptService.deleteDept(departmentId);
		log.info("###############################삭제테스트"+result);
		String result2 = "";
		if (result==99999) {
			result2 = "삭제실패";
			rttr.addFlashAttribute("result", result2);
			log.info("###############################삭제테스트"+result2);
		} else {
			result2 = "삭제완료";
			rttr.addFlashAttribute("result", result2);
			log.info("###############################삭제테스트"+result2);
		}
		return "redirect:/dept/list";
	}
	//전체조회 페이지
	@GetMapping("/list")
	public ModelAndView list(DeptVO vo, Paging paging) {
		ModelAndView mv = new ModelAndView("/dept/list");
		mv.setViewName("dept/list");//이렇게 세팅해도 됨
		mv.addObject("depts", deptService.getDeptAll(vo, paging));
		return mv;
	}
	//단건조회 페이지
	@GetMapping("/select")
	public String select(Model model, @RequestParam String departmentId	) {
		model.addAttribute("dept", deptService.getDept(departmentId));
		return "dept/select";
	}
	@GetMapping("/select/{departmentId}")
	public String select2(Model model, @PathVariable String departmentId) {
		model.addAttribute(deptService.getDept(departmentId));
		return "dept/select";
	}
}
