package com.hungry.spring.rvreply.dao;

import java.util.List;

import com.hungry.spring.rvreply.vo.RvReplyVO;

public interface RvReplyDAO {

	void addReply(RvReplyVO vo);

	List<RvReplyVO> listReply(int rv_no);

	void updateReply(RvReplyVO vo);

	void deleteRemove(int rvr_no);

	int getReviewNo(int rvr_no);

}
