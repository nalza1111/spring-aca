package home.my.hu.reply.mapper;

import java.util.List;

import home.my.hu.replyservice.ReplyVO;



public interface ReplyMapper {
	//댓글 글번호 조회
	public List<ReplyVO> getReply(String bno);
	//댓글작성
	public int insertReply(ReplyVO vo);
	//댓글삭제
	public int deleteReply(String rno);
	//댓글수정
	public int updateReply(ReplyVO vo);
	//댓글개별조회
	public ReplyVO reply(String rno);
	//최신댓글조회
}
