package com.hungry.spring.review.service;

import com.hungry.spring.review.dao.ReviewDAO;
import com.hungry.spring.review.vo.ReviewVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewDAO reviewDao;

	public void insertReview(ReviewVO vo) {
		this.reviewDao.insertReview(vo);
	}

	public List<ReviewVO> getReviewList() {
		return this.reviewDao.getReviewList();
	}

	public int getMyTotalCount(String m_id) {
		return this.reviewDao.getMyTotalCount(m_id);
	}

	public List<ReviewVO> getMyReviewList(String m_id) {
		return this.reviewDao.getMyReviewList(m_id);
	}

	public int getTotalCount() {
		return this.reviewDao.getTotalCount();
	}

	public void deleteReview(int rv_no) {
		this.reviewDao.deleteReview(rv_no);
	}

	public ReviewVO getReview(int rv_no) {
		return this.reviewDao.getReview(rv_no);
	}

	public void editReview(ReviewVO vo) {
		this.reviewDao.editReview(vo);
	}

	@Override
	public List<ReviewVO> getMyLikeList(String m_id) {
		return this.reviewDao.getMyLikeList(m_id);
	}
	
}
