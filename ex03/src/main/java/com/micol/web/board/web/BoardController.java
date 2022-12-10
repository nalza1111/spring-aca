package com.micol.web.board.web;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.micol.web.board.service.BoardService;
import com.micol.web.board.service.BoardVO;
import com.micol.web.common.Paging;
//@RunWith()
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@RequestMapping("/boardselectAll")
	@Test
	public String boardSelectAll(Model model, BoardVO vo, Paging paging) {
		paging.setPageUnit(5);
		model.addAttribute("boards", boardService.getBoardAll(vo, paging));
		return "board/boards";
	}
	@RequestMapping("/board")
	public String boardSelect(Model model, String bno) {
		model.addAttribute("board",boardService.getBoard(bno));
		return "board/board";
	}
}
