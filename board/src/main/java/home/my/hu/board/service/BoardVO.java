package home.my.hu.board.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	public String bno;
    public String title;
    public String content; 
    public String writer;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date regDate;
    public Date updateDate;
    
    List<String> bnos;
    
    Integer first = 1;
    Integer last = 10;
}
