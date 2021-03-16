package com.hungry.spring.dibs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.spring.dibs.dao.DibsDAO;
import com.hungry.spring.dibs.vo.DibsVO;

@Service
public class DibsServiceImpl implements DibsService {
	
	@Autowired
	private DibsDAO dibsDao;

	@Override
	public void addDibs(DibsVO vo) {
		this.dibsDao.addDibs(vo);
	}

	@Override
	public DibsVO dibsCheck(int rv_no, String m_id) {
		return this.dibsDao.dibsCheck(rv_no,m_id);
	}

	@Override
	public void delCheckVO() {
		this.dibsDao.delCheckVO();
	}

	@Override
	public void delDibs(DibsVO vo) {
		this.dibsDao.delDibs(vo);
	}

	@Override
	public List<DibsVO> getVOList(DibsVO vo) {
		return this.dibsDao.getVOList(vo);
	}
	
	

}
