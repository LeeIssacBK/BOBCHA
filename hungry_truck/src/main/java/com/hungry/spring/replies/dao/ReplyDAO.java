package com.hungry.spring.replies.dao;

import java.util.List;

import com.hungry.spring.replies.vo.ReplyVO;

public interface ReplyDAO {

	void addReply(ReplyVO vo);

	List<ReplyVO> listReply(int b_no);

	void updateReply(ReplyVO vo);

	int getBno(int r_no);

	void deleteRemove(int r_no);

}
