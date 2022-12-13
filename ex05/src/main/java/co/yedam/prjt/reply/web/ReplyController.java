package co.yedam.prjt.reply.web;

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

import co.yedam.prjt.reply.service.ReplyService;
import co.yedam.prjt.reply.service.ReplyVO;
import lombok.extern.log4j.Log4j;
@Log4j
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
		replyService.insertReply(vo);
		log.info(vo);
		return vo;
	}
	//댓글수정
	@PutMapping("/reply")
	public ReplyVO update(@RequestBody ReplyVO vo) {
		vo = replyService.updateReply(vo);
		log.info(vo);
		return vo;
	}
	//댓글삭제
	@DeleteMapping("/reply/{rno}")
	public int delete(ReplyVO vo, @PathVariable String rno) {
		return replyService.deleteReply(rno);
	}
	//단건조회
	@GetMapping("/reply/{rno}")
	public ReplyVO reply(ReplyVO vo, @PathVariable String rno) {
		return replyService.reply(rno);
	}
}
