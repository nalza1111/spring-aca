package co.yedam.prjt.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.yedam.prjt.emp.service.EmpService;
import co.yedam.prjt.emp.service.EmpVO;
import co.yedam.prjt.emp.service.UserListVO;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/test")
@Log4j
public class TestController {
	@Autowired EmpService empservice;
	@RequestMapping("/insertListpage")
	public String insertListPage() {
		return "empInsertList";
	}
	//등록 4-1
//		@RequestMapping(path = "/insertList",method = {RequestMethod.GET}) //겟으로 들어온 요청만 받겠음
//		public String insertList(UserListVO vo) {
//			log.info(vo);
//			return "home";
//	}
	//등록 4-2
	//@RequestMapping(path = "/insertList",method = {RequestMethod.GET, RequestMethod.POST}) //겟으로 들어온 요청만 받겠음(errRequest method 'POST' not supported) get,post 둘다 가능
	//위의 문구가 너무 기니까 줄임 어노테이션으로 만들어짐 조회 삭제(겟) 등록(포스트) 주로..
	//@GetMapping 겟매핑과 포스트매핑이렇게 적는 걸 추천
	@PostMapping
	public String insertList(UserListVO vo) {
		log.info(vo);
		return "home";
	}
	//등록 1) 부메랑 이용 // 만약 employeeids로 여러개 보내면 employeeIds=[100, 101, 102]
	@RequestMapping("/insert") //    /emp/insert
	public String insert(EmpVO vo) { //커맨드 객체 자동으로 수집되어 값이 담김
		log.info(vo);
		return "home";
	}
	//등록 3
	@RequestMapping("/params") // 리스트로 받을 땐 리퀘스트파람을 적어주기
	public String params (@RequestParam List<String> employeeIds) {
		log.info(employeeIds);
		return "main";
	}
	
	//등록 2)
	@RequestMapping("/insertparam") //int 를 하면 파라미터에 값이안들어갔을 때 에러 뜸 Integer은 널이 들어갈 수 있기 때문에 에러 안뜸
	public String insertparam(Integer age, @RequestParam(name="name")String firstName, @RequestParam(required = false, defaultValue = "kim") String lastName) { //request.getParameter("") 퍼스트네임을 담아서 리퀘스트에 담아라
	//public String insertparam(@RequestParam String firstName) { //@RequestParam 생략 가능
		//(@RequestPara String firstName) = request.getParameter("firstName") 같은 의미
		//(@RequestPara int age) = Integer.parseInt(request.getParameter("age")) 자동으로 해줌
		log.info(age);
		log.info(firstName);
		log.info(lastName); //firstName만 넘기면 lastName은 널값이 들어감 but @RequestParam이 붙은 파라미터는 필수...파라미터가 없으면 에러남.. 부메랑에서도 빼주기
		return "home";
		}
	//수정
	
	//삭제 1)
	@RequestMapping("/delete")
	public String delete(@RequestParam(defaultValue = "가") String id) {
		if(id.equals("가")) { //149번입력시 dept제약조건에 걸림
			log.info("아이디 오입력");
		} else {
			log.info(empservice.deleteEmp(id)+"삭제완료");
		}
		return "home";
	}
		//삭제 2) deletepath 이용 부메랑에 쿼리스트링사용하지 않고 주소에 바로 ~~/107/10붙이기
		@RequestMapping("/delete/{empid}/{deptid}") //parhVariable과 {매개변수} 명 일치
		public String deletepath(@PathVariable String empid,
								 @PathVariable String deptid) {
			log.info(empid);
			return "home";
		}
	//조회
}
