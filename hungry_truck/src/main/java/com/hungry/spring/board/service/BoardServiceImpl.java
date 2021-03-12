package com.hungry.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hungry.spring.board.dao.BoardDAO;
import com.hungry.spring.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	//전체글 개수 가져오기
	@Override
	public int getTotalCount() {
		return this.boardDAO.getTotalCount();
	}
	
	//글 목록 가져오기
	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.boardDAO.getBoardList(b);
	}

	//게시글 내용보기 //AOP를 통한 트랜잭션 처리
	@Transactional
	@Override
	public BoardVO getCont(int b_no) {
		this.boardDAO.updateHit(b_no); //조회수 올리기
		return this.boardDAO.getCont(b_no); //글정보 가져오기
	}//조회수 증가+내용보기가 함께가야함. 둘중하나라도 에러발생시 반환하지않음.
	
	//게시물 저장
	@Override
	public void insertBoard(BoardVO b) {
		this.boardDAO.insertBoard(b);
	}
	
	//게시물 수정
	@Override
	public void editBoard(BoardVO b) {
		this.boardDAO.editBoard(b);
	}

	//게시물 삭제
	@Override
	public void delBoard(int b_no) {
		this.boardDAO.delBoard(b_no);
	}

	//m_id를 통해 BoardList객체리스트 가져오기
	@Override
	public List<BoardVO> getMyBoardList(String m_id) {
		return this.boardDAO.getMyBoardList(m_id);
	}

	@Override
	public int getMyTotalCount(String m_id) {
		return this.boardDAO.getMyTotalCount(m_id);
	}
	
	
	
	
	
	
	
	
	
	
	
}
