package com.hungry.spring.replies.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungry.spring.replies.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addReply(ReplyVO vo) {
		this.sqlSession.insert("reply_in",vo);
	}

	@Override
	public List<ReplyVO> listReply(int b_no) {
		return this.sqlSession.selectList("reply_list",b_no);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		this.sqlSession.update("reply_up",vo);
	}

	@Override
	public void deleteRemove(int r_no) {
		this.sqlSession.delete("reply_del",r_no);
	}

	@Override
	public int getBno(int r_no) {
		return this.sqlSession.selectOne("reply_b_no",r_no);
	}
	

}
