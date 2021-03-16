package com.hungry.spring.review.service;

import com.hungry.spring.review.vo.ReviewVO;
import java.util.List;

public interface ReviewService {
	void insertReview(ReviewVO paramReviewVO);

	List<ReviewVO> getReviewList();

	int getMyTotalCount(String paramString);

	List<ReviewVO> getMyReviewList(String paramString);

	int getTotalCount();

	void deleteReview(int paramInt);

	ReviewVO getReview(int paramInt);

	void editReview(ReviewVO paramReviewVO);

	List<ReviewVO> getMyLikeList(String m_id);
}
