package com.hungry.spring.replies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hungry.spring.replies.service.ReplyService;
import com.hungry.spring.replies.vo.ReplyVO;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	//댓글 등록
	@RequestMapping()
	public ResponseEntity<String> register(@RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			this.replyService.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//게시물 번호에 맞는 댓글 목록
	@RequestMapping("/all/{b_no}")
	public ResponseEntity<List<ReplyVO>>list(@PathVariable("b_no")int b_no){
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(this.replyService.listReply(b_no),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	//댓글 수정
	@RequestMapping(value="/{r_no}",method= {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("r_no") int r_no, @RequestBody ReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setR_no(r_no);
			this.replyService.updateReply(vo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	//댓글 삭제
	@RequestMapping(value="{r_no}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("r_no")int r_no){
		ResponseEntity<String> entity = null;
		
		try {
			this.replyService.deleteRemove(r_no);//댓글번호를 기준으로 댓글을 삭제
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
}
