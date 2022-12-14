package co.yedam.prjt.reply.service;

import java.util.List;

public interface ReplyService {
	//댓글 글번호 조회
	public List<ReplyVO> getReply(String bno);
	//댓글작성
	public ReplyVO insertReply(ReplyVO vo);
	//댓글삭제
	public int deleteReply(String rno);
	//댓글수정
	public int updateReply(ReplyVO vo);
	//댓글개별조회
	public ReplyVO reply(String rno);
}
