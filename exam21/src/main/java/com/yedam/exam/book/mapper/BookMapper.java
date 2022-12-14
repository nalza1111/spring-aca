package com.yedam.exam.book.mapper;

import java.util.List;

import com.yedam.exam.book.servcice.BookVO;

public interface BookMapper {
	//도서목록조회
	public List<BookVO> getBooks();
	//도서정보등록
	public int insertBook(BookVO vo);
	//도서대여현황조회
	public BookVO getBook(String bookNo);
	
	//도서번호
	public int getBookNum();
}
