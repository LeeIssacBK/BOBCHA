package com.hungry.spring.replies.vo;

import lombok.Data;

@Data
public class ReplyVO {
	
	private int r_no;
	private int b_no;
	private String replyer;
	private String replytext;
	private String regdate;
	private String updatedate;
	private int m_no;

}
