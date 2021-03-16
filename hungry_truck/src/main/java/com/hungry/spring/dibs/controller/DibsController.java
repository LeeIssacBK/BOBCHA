package com.hungry.spring.dibs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hungry.spring.dibs.service.DibsService;
import com.hungry.spring.dibs.vo.DibsVO;

@RestController
@RequestMapping("/dibs")
public class DibsController {
	
	@Autowired
	private DibsService dibsService;

	//찜컬럼 변경
	@RequestMapping
	public ResponseEntity<String> register(@RequestBody DibsVO vo){
		ResponseEntity<String> entity = null;
		//vo객체를 받아서 중복된 레코드가 있는지 List에 담음.
		List<DibsVO> checkList = this.dibsService.getVOList(vo);
		//리스트로 받아서 같은레코드가 1보다 큰경우
		if(checkList.size() > 1) {
			this.dibsService.delCheckVO();//전체 중복된 레코드를 삭제
		}
		boolean flag = true;
		try {
			for(DibsVO c : checkList) {
				//리스트 안에 m_id와 rv_no가 같은 레코드가 존재하는경우
				if((c.getM_id().equals(vo.getM_id()))&&(c.getRv_no()==vo.getRv_no())) {
					this.dibsService.delDibs(vo);//찜 제거
					flag = false;
				}
			}
			if(flag) {				
				this.dibsService.addDibs(vo);//찜체크
			}
			entity = new ResponseEntity<>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//밥차에 맞는 찜만 가져옴
	@RequestMapping("/dibsCheck/{rv_no}")
	public ResponseEntity<DibsVO>dibsCheck(@PathVariable("rv_no")int rv_no, HttpSession session){
		ResponseEntity<DibsVO>entity = null;
		String m_id = (String)session.getAttribute("m_id");
		try {
			entity = new ResponseEntity<>(this.dibsService.dibsCheck(rv_no, m_id),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	

}
