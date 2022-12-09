package com.micol.web.board.service;

import java.util.List;

import lombok.Data;
@Data
public class BoardVO {
	public String bno;
    public String title;
    public String content; 
    public String writer;
    public String regDate;
    public String updateDate;
    
    List<String> bnos;
    
}
