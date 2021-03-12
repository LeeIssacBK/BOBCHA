package com.hungry.spring.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungry.spring.board.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//총글 개수 구하기
	@Override
	public int getTotalCount() {
		return this.sqlSession.selectOne("b_count");
	}
	
	//전체 글 목록 가져오기
	@Override
	public List<BoardVO> getBoardList(BoardVO b) {
		return this.sqlSession.selectList("b_list",b);
	}

	//게시글 내용보기
	@Override
	public BoardVO getCont(int b_no) {
		return this.sqlSession.selectOne("b_cont",b_no);
	}
	
	//조회수 올리기
	@Override
	public void updateHit(int b_no) {
		this.sqlSession.update("b_hit",b_no);
	}
	
	//게시물 저장
	@Override
	public void insertBoard(BoardVO b) {
		this.sqlSession.insert("b_insert",b);
	}
	
	//게시물 수정
	@Override
	public void editBoard(BoardVO b) {
		this.sqlSession.update("b_update",b);
	}
	
	//게시물 삭제
	@Override
	public void delBoard(int b_no) {
		this.sqlSession.delete("b_delete",b_no);
	}

	//회원 ID를 통해 객체 가져오기
	@Override
	public List<BoardVO> getMyBoardList(String m_id) {
		return this.sqlSession.selectList("b_MyBoardList",m_id);
	}
	
	//내가쓴글 개수
	@Override
	public int getMyTotalCount(String m_id) {
		return this.sqlSession.selectOne("b_MyCount",m_id);
	}
	
	//댓글의 개수를 올려줌
	@Override
	public void updateReply(int b_no, int count) {
		Map<String,Object> pm = new HashMap<>();
		pm.put("b_no", b_no);
		pm.put("count", count);
		this.sqlSession.update("upReplyCnt",pm);
	}
	
	
	
	
	
	
	
	
	

}
