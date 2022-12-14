package com.yedam.exam.book.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.exam.book.servcice.BookService;
import com.yedam.exam.book.servcice.BookVO;

@RestController
public class BookController {
	@Autowired BookService bookService;
	//게시판이동
	@GetMapping("/book/books")
	public ModelAndView getBooks() {
		return new ModelAndView("book/books");
	}
	//게시판조회
	@GetMapping("/book/bookList")
	public List<BookVO> bookList() {
		return bookService.getBooks();
	}
	
	//도서등록 페이지
	@GetMapping("/book/insertbook")
	public ModelAndView insertbook() {
		ModelAndView mv = new ModelAndView("book/insertbook");
		mv.addObject("bookNum",bookService.getBookNum());
		return mv;
	}
	//도서등록
	@PostMapping("/book/insertbook")
	public BookVO insert(BookVO vo) {
		bookService.insertBook(vo);
		return vo;
	}
	//게시판상세
	@GetMapping("/book/bookSelect")
	public BookVO bookSelet(String bookNo) {
		bookService.getBook(bookNo);
		return BookVO;
	}
	
}
