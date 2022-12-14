package com.company.app.users.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.company.app.users.service.UserService;
import com.company.app.users.service.UserVO;

@RestController //Controller + ResponseBody => 이거 적으면 밑에 ResponseBody생략가능
public class UsersController {
	@Autowired UserService userService;
	
	@GetMapping("userPage")
	public ModelAndView userPage() {//이건 json변환을 안함
		return new ModelAndView("users");
	}
	
	
	//등록 (리퀘스트바디 노)
	@PostMapping("/users")//레스트에서는 포스트 자체가 등록이란 뜻
	public UserVO insert(UserVO vo) {
		System.out.println(vo);
		userService.insertUser(vo);
		return vo;
	}
	//등록 (리퀘스트바디 예스)
//	@PostMapping("/users")//레스트에서는 포스트 자체가 등록이란 뜻
//	public UserVO insert(UserVO vo) {
//		System.out.println(vo);
//		userService.insertUser(vo);
//		return vo;
//	}
	//수정
	@PutMapping("/users")
	public UserVO update(@RequestBody UserVO vo) { //put은 받을 때 @RequestBody 하지 않으면 널이뜸
		userService.updateUser(vo);					//이거 쓰면 부메랑에서 보낼때 json타입으로 보내야 함
		return vo;									//insert도 가능
	}
	//삭제
	@DeleteMapping("/users/{id}")
	public int delete(UserVO vo, @PathVariable String id) {
		return userService.deleteUser(vo);
	}
	//단건조회
	@GetMapping("/users/{id}")
	public UserVO user(UserVO vo, @PathVariable String id){
		//vo.setId(id);
		return userService.getUser(vo);
	}
	//전체조회 1)
	@GetMapping("/users")
	@ResponseBody
	public List<UserVO> userlist(){
		return userService.getUserList(null);
	}
	//전체조회 2)
	@GetMapping("/users2")
	public @ResponseBody List<UserVO> userlist2(){//자동변환해줌
		return userService.getUserList(null);
	}
}
