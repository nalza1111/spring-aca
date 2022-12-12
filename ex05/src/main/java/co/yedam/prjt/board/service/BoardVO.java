package co.yedam.prjt.board.service;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BoardVO {
	public String bno;
    public String title;
    public String content; 
    public String writer;
    public String regDate;
    public String updateDate;
    
    List<String> bnos;
    
    Integer first = 1;
    Integer last = 10;
    
}
