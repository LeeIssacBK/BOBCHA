package com.hungry.spring.review.dao;

import com.hungry.spring.review.vo.ReviewVO;
import java.util.List;

public interface ReviewDAO {
	void insertReview(ReviewVO paramReviewVO);

	List<ReviewVO> getReviewList();

	int getMyTotalCount(String paramString);

	List<ReviewVO> getMyReviewList(String paramString);

	int getTotalCount();

	void deleteReview(int paramInt);

	ReviewVO getReview(int paramInt);

	void editReview(ReviewVO paramReviewVO);

	int updateReply(int rv_no, int count);

}
