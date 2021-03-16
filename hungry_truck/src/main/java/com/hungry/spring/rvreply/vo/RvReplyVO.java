package com.hungry.spring.rvreply.vo;

import lombok.Data;

@Data
public class RvReplyVO {
	private int rvr_no;
	private int rv_no;
	private int rvr_rating;
	private String rvr_replyer;
	private String rvr_replytext;
	private String rvr_regdate;
	private String rvr_updatedate;
}
