package com.hungry.spring.dibs.dao;

import java.util.List;

import com.hungry.spring.dibs.vo.DibsVO;

public interface DibsDAO {

	void addDibs(DibsVO vo);

	DibsVO dibsCheck(int rv_no, String m_id);

	void delCheckVO();

	void delDibs(DibsVO vo);

	List<DibsVO> getVOList(DibsVO vo);

	int getMyLikeCount(String m_id);
	
	

}
