package com.hungry.spring.board.service;

import java.util.List;

import com.hungry.spring.board.vo.BoardVO;

public interface BoardService {

	int getTotalCount();

	List<BoardVO> getBoardList(BoardVO b);

	BoardVO getCont(int b_no);

	void insertBoard(BoardVO b);

	void editBoard(BoardVO b);

	void delBoard(int b_no);
	
	List<BoardVO> getMyBoardList(String m_id);
	
	int getMyTotalCount(String m_id);

}
