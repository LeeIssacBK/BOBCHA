package com.hungry.spring.rvreply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hungry.spring.rvreply.service.RvReplyService;
import com.hungry.spring.rvreply.vo.RvReplyVO;

@RestController
@RequestMapping("/reviewReplies")
public class RvReplyController {
	
	@Autowired
	private RvReplyService rvReplyService;
	
	//리뷰댓글 등록
	@RequestMapping
	public ResponseEntity<String> register(@RequestBody RvReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			this.rvReplyService.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//밥차에 맞는 댓글만 가져옴
	@RequestMapping("/all/{rv_no}")
	public ResponseEntity<List<RvReplyVO>>list(@PathVariable("rv_no")int rv_no){
		ResponseEntity<List<RvReplyVO>>entity = null;
		try {
			entity = new ResponseEntity<>(this.rvReplyService.listReply(rv_no),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//리뷰댓글 수정
	@RequestMapping(value="/{rvr_no}", method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("rvr_no")int rvr_no, @RequestBody RvReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setRvr_no(rvr_no);
			this.rvReplyService.updateReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//리뷰댓글 삭제
	@RequestMapping(value="/{rvr_no}", method= {RequestMethod.DELETE})
	public ResponseEntity<String> delete(@PathVariable("rvr_no")int rvr_no){
		ResponseEntity<String> entity = null;
		try {
			this.rvReplyService.deleteRemove(rvr_no);//댓글번호를 기준으로 삭제한다.
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	

}
