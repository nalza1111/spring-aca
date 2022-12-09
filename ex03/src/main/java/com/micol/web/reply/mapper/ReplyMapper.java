package com.micol.web.reply.mapper;

import java.util.List;

import com.micol.web.reply.service.ReplyVO;


public interface ReplyMapper {
	//댓글 글번호 조회
	public List<ReplyVO> getReply(String bno);
	//댓글작성
	public int insertReply(ReplyVO vo);
	//댓글삭제
	public int deleteReply(String rno);
}
