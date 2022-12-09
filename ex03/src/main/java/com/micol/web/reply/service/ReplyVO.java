package com.micol.web.reply.service;

import org.springframework.stereotype.Component;

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
      String replyDate;
      String updateDate;
}
