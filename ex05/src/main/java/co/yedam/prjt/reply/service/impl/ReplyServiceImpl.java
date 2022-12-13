package co.yedam.prjt.reply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.yedam.prjt.reply.mapper.ReplyMapper;
import co.yedam.prjt.reply.service.ReplyService;
import co.yedam.prjt.reply.service.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired ReplyMapper replyMapper;
	
	
	@Override
	public List<ReplyVO> getReply(String bno) {
		return replyMapper.getReply(bno);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		return replyMapper.insertReply(vo);
	}

	@Override
	public int deleteReply(String rno) {
		return replyMapper.deleteReply(rno);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		return replyMapper.updateReply(vo);
	}

}
