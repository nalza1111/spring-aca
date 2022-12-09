package com.micol.web.reply.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micol.web.reply.mapper.ReplyMapper;
import com.micol.web.reply.service.ReplyService;
import com.micol.web.reply.service.ReplyVO;

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

}
