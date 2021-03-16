package com.hungry.spring.rvreply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hungry.spring.review.dao.ReviewDAO;
import com.hungry.spring.rvreply.dao.RvReplyDAO;
import com.hungry.spring.rvreply.vo.RvReplyVO;

@Service
public class RvReplyServiceImpl implements RvReplyService {
	
	@Autowired
	private RvReplyDAO rvReplyDao;
	
	@Autowired
	private ReviewDAO reviewDao;
	
	//리뷰 댓글개수 위한 AOP트랜잭션 처리
	@Transactional
	@Override
	public void addReply(RvReplyVO vo) {
		this.rvReplyDao.addReply(vo);
		this.reviewDao.updateReply(vo.getRv_no(), 1);
	}

	@Override
	public List<RvReplyVO> listReply(int rv_no) {
		return this.rvReplyDao.listReply(rv_no);
	}

	@Override
	public void updateReply(RvReplyVO vo) {
		this.rvReplyDao.updateReply(vo);
	}
	
	//댓글 삭제시 -1로 줄여줌
	@Transactional
	@Override
	public void deleteRemove(int rvr_no) {
		System.out.println("ServiceImpl"+rvr_no);
		int rv_no = this.rvReplyDao.getReviewNo(rvr_no);
		System.out.println("rv_no:"+rv_no);
		this.reviewDao.updateReply(rv_no, -1);
		this.rvReplyDao.deleteRemove(rvr_no);
	}
	
	
	
	

}
