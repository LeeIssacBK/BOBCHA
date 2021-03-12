package com.hungry.spring.board.vo;

import lombok.Data;

@Data
public class BoardVO {
	private int b_no;
	private String b_title;
	private String b_writer;
	private String b_cont;
	private int viewcnt;
	private String regdate;
	private int reply_cnt;//댓글수 카운터 컬럼추가
	
	//페이징(쪽나누기)위한 변수선언
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호
}
