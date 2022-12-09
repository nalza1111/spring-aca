package com.micol.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.micol.web.reply.service.ReplyService;
import com.micol.web.reply.service.ReplyVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyServiceClient {
	
	@Autowired ReplyService replyService;
	
	//@Test
	public void getReply() {
		String number = "21";
		List<ReplyVO> result = replyService.getReply(number);
		result.forEach(r ->log.info(r));
	}
	//@Test
	public void insertReply() {
		ReplyVO vo = new ReplyVO();
		vo.setBno("21");
		vo.setReply("댓글3");
		vo.setReplyer("userHome");
		log.info(replyService.insertReply(vo)+"건 등록");
	}
	@Test
	public void deleteReply() {
		log.info(replyService.deleteReply("4")+"건 삭제");
	}
}
