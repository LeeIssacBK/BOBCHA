package com.hungry.spring.dibs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungry.spring.dibs.vo.DibsVO;

@Repository
public class DibsDAOImpl implements DibsDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addDibs(DibsVO vo) {
		this.sqlSession.insert("add_dibs",vo);
	}

	@Override
	public DibsVO dibsCheck(int rv_no, String m_id) {
		Map<String, Object>hm = new HashMap<>();
		hm.put("rv_no",rv_no);
		hm.put("m_id",m_id);
		return this.sqlSession.selectOne("dibsCheck",hm);
	}

	@Override
	public void delCheckVO() {
		this.sqlSession.delete("delCheckVO");
	}

	@Override
	public void delDibs(DibsVO vo) {
		this.sqlSession.delete("del_dibs",vo);
	}

	@Override
	public List<DibsVO> getVOList(DibsVO vo) {
		return this.sqlSession.selectList("getVOList",vo);
	}
	

}
