package com.hungry.spring.rvreply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungry.spring.rvreply.vo.RvReplyVO;

@Repository
public class RvReplyDAOImpl implements RvReplyDAO {
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public void addReply(RvReplyVO vo) {
		this.sqlsession.insert("rvr_insert",vo);
	}

	@Override
	public List<RvReplyVO> listReply(int rv_no) {
		return this.sqlsession.selectList("rvr_list",rv_no);
	}

	@Override
	public void updateReply(RvReplyVO vo) {
		this.sqlsession.update("rvr_update",vo);
	}

	@Override
	public void deleteRemove(int rvr_no) {
		this.sqlsession.delete("rvr_delete",rvr_no);
	}

	@Override
	public int getReviewNo(int rvr_no) {
		return this.sqlsession.selectOne("get_rv_no",rvr_no);
	}
	
	
	
	
	
	
	

}
