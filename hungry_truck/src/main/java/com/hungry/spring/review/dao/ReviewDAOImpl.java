package com.hungry.spring.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungry.spring.review.vo.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	@Autowired
	private SqlSession sqlSession;

	public void insertReview(ReviewVO vo) {
		this.sqlSession.insert("insertReview", vo);
	}

	public List<ReviewVO> getReviewList() {
		return this.sqlSession.selectList("reviewList");
	}

	public int getMyTotalCount(String m_id) {
		return ((Integer) this.sqlSession.selectOne("r_myCount", m_id)).intValue();
	}

	public List<ReviewVO> getMyReviewList(String m_id) {
		return this.sqlSession.selectList("r_myList", m_id);
	}

	public int getTotalCount() {
		return ((Integer) this.sqlSession.selectOne("r_totCount")).intValue();
	}

	public void deleteReview(int rv_no) {
		this.sqlSession.delete("r_deleteReview", Integer.valueOf(rv_no));
	}

	public ReviewVO getReview(int rv_no) {
		return (ReviewVO) this.sqlSession.selectOne("r_oneReview", Integer.valueOf(rv_no));
	}

	public void editReview(ReviewVO vo) {
		this.sqlSession.update("r_updateReview", vo);
	}

	@Override
	public int updateReply(int rv_no, int count) {
		Map<String, Object> hm = new HashMap<>();
		hm.put("rv_no", rv_no);
		hm.put("count", count);
		return this.sqlSession.update("rvr_updateCount", hm);
	}

	@Override
	public List<ReviewVO> getMyLikeList(String m_id) {
		return this.sqlSession.selectList("getMyLikeList",m_id);
	}
	
	

}
