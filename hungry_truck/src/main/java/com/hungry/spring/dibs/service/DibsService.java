package com.hungry.spring.dibs.service;

import java.util.List;

import com.hungry.spring.dibs.vo.DibsVO;

public interface DibsService {

	void addDibs(DibsVO vo);

	DibsVO dibsCheck(int rv_no, String m_id);

	void delCheckVO();

	void delDibs(DibsVO vo);

	List<DibsVO> getVOList(DibsVO vo);

}
