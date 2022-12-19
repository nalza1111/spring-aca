package home.my.hu.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import home.my.hu.board.mapper.BoardMapper;
import home.my.hu.board.service.BoardService;
import home.my.hu.board.service.BoardVO;
import home.my.hu.common.Paging;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired BoardMapper boardMapper;
	@Override
	public BoardVO getBoard(String bno) {
		return boardMapper.getBoard(bno);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return boardMapper.updateBoard(vo);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		return boardMapper.insertBoard(vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return boardMapper.deleteBoard(vo);
	}

	@Override
	public List<Map<String, Object>> getBoardAll(BoardVO vo, Paging paging) {
		paging.setTotalRecord(boardMapper.count(vo));
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		return boardMapper.getBoardAll(vo);
	}

	@Override
	public int count(BoardVO vo) {
		return boardMapper.count(vo);
	}


}
