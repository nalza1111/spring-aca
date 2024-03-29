package co.yedam.prjt.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.yedam.prjt.board.service.BoardService;
import co.yedam.prjt.board.service.BoardVO;
import co.yedam.prjt.common.Paging;
import co.yedam.prjt.reply.service.ReplyService;
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService boardService;
	@Autowired ReplyService replyService;
	
	//보드 전체조회
	@GetMapping("/list")
	public String boardSelectAll(Model model, BoardVO vo, Paging paging) {
		paging.setPageUnit(5);
		model.addAttribute("boards", boardService.getBoardAll(vo, paging));
		return "board/list";
	}
	//보드 단건조회
	@GetMapping("/board")
	public String boardSelect(Model model, String bno) {
		model.addAttribute("board",boardService.getBoard(bno));
		return "board/board";
	}
}
