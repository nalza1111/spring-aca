package com.yedam.exam.book.servcice;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {
	String bookNo;      
	String bookName; 
	String bookCoverimg;
	@JsonFormat(pattern = "yyyy/MM/dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date bookDate;     
	String bookPrice;    
	String bookPublisher;
	String bookInfo;
}
