package co.yedam.prjt.reply.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.prjt.reply.service.ReplyService;

@RestController
public class ReplyController {
	@Autowired ReplyService replyService;
	//댓글확인
	//@GetMapping
	
	//댓글등록
	//@PostMapping
	//댓글수정
	//@PutMapping
	//댓글삭제
	//@DeleteMapping
}
