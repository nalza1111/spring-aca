package home.my.hu.reply.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import home.my.hu.replyservice.ReplyService;
import home.my.hu.replyservice.ReplyVO;

@RequestMapping("/board")
@RestController
public class ReplyController {
	@Autowired ReplyService replyService;
	//댓글확인
	@GetMapping("/reply")
	public List<ReplyVO> getReply(String bno){
		List<ReplyVO> list = replyService.getReply(bno);
		return list;
	}
	//댓글등록
		@PostMapping("/reply")
		public ReplyVO insert(ReplyVO vo) {
		vo = replyService.insertReply(vo);
		return vo;
	}

}
