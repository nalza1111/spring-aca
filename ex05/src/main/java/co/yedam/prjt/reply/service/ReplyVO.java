package co.yedam.prjt.reply.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ReplyVO {
	  String rno;
      String bno;
      String reply;
      String replyer;
      @JsonFormat(pattern = "yyyy-MM-dd")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      String replyDate;
      @JsonFormat(pattern = "yyyy-MM-dd")
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      String updateDate;
}
