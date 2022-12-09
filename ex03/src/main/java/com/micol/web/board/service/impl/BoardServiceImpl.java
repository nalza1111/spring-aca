package com.micol.web.board.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micol.web.board.service.BoardVO;
import com.micol.web.board.mapper.BoardMapper;
import com.micol.web.board.service.BoardService;

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
	public List<Map<String, Object>> getBoardAll(BoardVO vo) {
		return boardMapper.getBoardAll(vo);
	}

	@Override
	public int count(BoardVO vo) {
		return boardMapper.count(vo);
	}

}
