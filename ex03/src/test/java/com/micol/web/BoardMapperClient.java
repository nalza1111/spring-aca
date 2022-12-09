package com.micol.web;

import java.io.Console;
import java.util.Arrays;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.micol.web.board.mapper.BoardMapper;
import com.micol.web.board.service.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperClient {
	@Autowired BoardMapper mapper;
	@Autowired SqlSession mybatis;
	
	@Test
	public void mybatisTest() {
		System.out.println(mybatis.selectList("com.micol.web.board.BoardMapper.getBoardAll"));
	}
	
	//@Test
	public void getBoard() {
		BoardVO vo = mapper.getBoard("1");
		System.out.println(vo);;
	}
	//@Test
	public void insertBoard() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Title");
		vo.setContent("Content");
		vo.setWriter("Writer");
		int result = mapper.insertBoard(vo);
		System.out.println(result + "�� �Էµ�.");
	}
	//@Test
	public void updateBoard() {
		BoardVO vo = new BoardVO();
		vo.setBno("1");
		vo.setTitle("Title");
		vo.setContent("Content2");
		int result = mapper.updateBoard(vo);
		System.out.println(result + "�� ������Ʈ��.");
	}
	//@Test
	public void deleteBoard() {
		BoardVO vo = new BoardVO();
		vo.setBno("1");
		int result = mapper.deleteBoard(vo);
		System.out.println(result + "�� ������.");
	}
	//@Test
	public void getBoardAll() {
		BoardVO vo = new BoardVO();
		vo.setTitle("c");
		mapper.getBoardAll(vo).forEach(board -> System.out.println(vo));
	}
	//@Test
	public void getBoardAll2() {
		BoardVO vo = new BoardVO();
		vo.setBnos(Arrays.asList("21","22","23"));
		//vo.setWriter("Writer");
		//System.out.println(Arrays.asList("21","22","23"));
		mapper.getBoardAll(vo).forEach(board -> System.out.println(board.get("bno")));
	}
	//@Test
	public void count() {
		BoardVO vo = new BoardVO();
		vo.setTitle("t");
		System.out.println(mapper.count(vo));
	}
}
