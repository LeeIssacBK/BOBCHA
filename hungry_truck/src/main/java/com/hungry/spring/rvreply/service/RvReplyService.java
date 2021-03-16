package com.hungry.spring.rvreply.service;

import java.util.List;

import com.hungry.spring.rvreply.vo.RvReplyVO;

public interface RvReplyService {

	void addReply(RvReplyVO vo);

	List<RvReplyVO> listReply(int rv_no);

	void updateReply(RvReplyVO vo);

	void deleteRemove(int rvr_no);

}
