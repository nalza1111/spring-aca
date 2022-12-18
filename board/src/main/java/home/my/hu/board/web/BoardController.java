package home.my.hu.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import home.my.hu.board.service.BoardService;
import home.my.hu.board.service.BoardVO;
import home.my.hu.common.Paging;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired BoardService boardService;

	//보드리스트로 이동
	@GetMapping("/boardList")
	public void boardList(Model model, BoardVO vo, Paging paging) {
		model.addAttribute("boards", boardService.getBoardAll(vo, paging));
	}
	//보드등록페이지로 이동
	@GetMapping("/boardInsert")
	public String boardInsert() {
		return "board/boardInsert";
	}
	//보드등록
	@PostMapping("/insert")
	public String insert(BoardVO vo, RedirectAttributes rttr) {
		boardService.insertBoard(vo);
		rttr.addFlashAttribute("result", "등록완료");
		return "redirect:/board/boardList";
	}
	//수정페이지로 이동
	//보드수정
	//보드 삭제
	@GetMapping("/delete")
	public String delete(@RequestParam String bno, RedirectAttributes rttr) {
		BoardVO vo = new BoardVO();
		vo.setBno(bno);
		boardService.deleteBoard(vo);
		rttr.addFlashAttribute("result", "삭제완료");
		return "redirect:/board/boardList";
	}
	@PostMapping("/delete")
	public String delete2(@RequestParam String bno, RedirectAttributes rttr) {
		BoardVO vo = new BoardVO();
		vo.setBno(bno);
		boardService.deleteBoard(vo);
		rttr.addFlashAttribute("result", "삭제완료");
		return "redirect:/board/boardList";
	}
	//단건조회 페이지로 이동
	@GetMapping("/boardEach")
	public String board(Model model, @RequestParam String bno) {
		model.addAttribute("board", boardService.getBoard(bno));
		return "board/boardEach";
	}
}
