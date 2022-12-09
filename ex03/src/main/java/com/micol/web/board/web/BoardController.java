package com.micol.web.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.micol.web.board.service.BoardService;
import com.micol.web.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@RequestMapping("boardselectAll")
	public String boardSelectAll(Model model, BoardVO vo) {
		model.addAttribute("boards", boardService.getBoardAll(vo));
		return "boards";
	}
}
