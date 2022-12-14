package co.yedam.prjt.reply.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyVO {
	  String rno;
      public String bno;
      String reply;
      String replyer;
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(pattern = "yyyy-MM-dd")
      Date replydate;
      @DateTimeFormat(pattern = "yyyy-MM-dd")
      @JsonFormat(pattern = "yyyy-MM-dd")
      Date updatedate;
}
