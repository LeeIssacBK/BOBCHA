package com.hungry.spring.replies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hungry.spring.board.dao.BoardDAO;
import com.hungry.spring.replies.dao.ReplyDAO;
import com.hungry.spring.replies.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	//댓글 등록
	@Transactional
	@Override
	public void addReply(ReplyVO vo) {
		this.replyDAO.addReply(vo);// 댓글 추가
		this.boardDAO.updateReply(vo.getB_no(),1);//댓글추가 시 reply_cnt컬럼에 댓글개수 1증가
	}


	//댓글 목록
	@Override
	public List<ReplyVO> listReply(int b_no) {
		return this.replyDAO.listReply(b_no);
	}


	@Override
	public void updateReply(ReplyVO vo) {
		this.replyDAO.updateReply(vo);
	}


	@Transactional
	@Override
	public void deleteRemove(int r_no) {
		int b_no = this.replyDAO.getBno(r_no);
		this.replyDAO.deleteRemove(r_no);
		this.boardDAO.updateReply(b_no, -1);
	}
	
	
	

}
