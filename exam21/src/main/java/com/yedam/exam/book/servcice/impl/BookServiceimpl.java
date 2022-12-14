package com.yedam.exam.book.servcice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.exam.book.mapper.BookMapper;
import com.yedam.exam.book.servcice.BookService;
import com.yedam.exam.book.servcice.BookVO;

@Service
public class BookServiceimpl implements BookService{
	@Autowired BookMapper bookMapper;
	@Override
	public List<BookVO> getBooks() {
		return bookMapper.getBooks();
	}

	@Override
	public int insertBook(BookVO vo) {
		return bookMapper.insertBook(vo);
	}

	@Override
	public BookVO getBook(String bookNo) {
		return bookMapper.getBook(bookNo);
	}

	@Override
	public int getBookNum() {
		return bookMapper.getBookNum();
	}

}
