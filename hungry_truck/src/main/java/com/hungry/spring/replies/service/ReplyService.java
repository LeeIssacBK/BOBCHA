package com.hungry.spring.replies.service;

import java.util.List;

import com.hungry.spring.replies.vo.ReplyVO;

public interface ReplyService {

	void addReply(ReplyVO vo);

	List<ReplyVO> listReply(int b_no);

	void updateReply(ReplyVO vo);

	void deleteRemove(int r_no);

}
