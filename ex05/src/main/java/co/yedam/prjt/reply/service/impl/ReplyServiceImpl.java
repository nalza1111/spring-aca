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
	public ReplyVO insertReply(ReplyVO vo) {
		//입력이 성공했다면 조회 후 vo를 리턴
		System.out.println(vo.toString());
		int result = replyMapper.insertReply(vo);
		System.out.println(vo.toString());
		if(result>0) {
			//가장 최신 댓글검색
			return(replyMapper.reply(vo.getRno()));
		} else {
			//입력시간과 업데이트 시간이 널임
			return vo;
		}
	}

	@Override
	public int deleteReply(String rno) {
		return replyMapper.deleteReply(rno);
	}

	@Override
	public ReplyVO updateReply(ReplyVO vo) {
		//입력이 성공했다면 조회 후 vo를 리턴
		int result = replyMapper.updateReply(vo);
		if(result>0) {
			return(replyMapper.reply(vo.getRno()));
		} else {
			//입력시간과 업데이트 시간이 널임
			return vo;
		}
	}

	@Override
	public ReplyVO reply(String rno) {
		return replyMapper.reply(rno);
	}

}
