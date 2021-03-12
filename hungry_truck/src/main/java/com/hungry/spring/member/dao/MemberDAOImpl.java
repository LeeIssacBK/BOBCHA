package com.hungry.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungry.spring.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	//아이디 중복체크
	@Override
	public MemberVO id_check(String id) {
		return this.sqlSession.selectOne("id_c",id);
	}

	//아이디 저장
	@Override
	public void insertMember(MemberVO m) {
		this.sqlSession.insert("insert_m",m);
	}
	
	//로그인 체크
	@Override
	public MemberVO login_check(String m_id) {
		return this.sqlSession.selectOne("log_c",m_id);
	}

	//아이디 찾기
	@Override
	public List<MemberVO> findId(MemberVO m) {
		return this.sqlSession.selectList("findId",m);
	}

	//비밀번호 찾기
	@Override
	public MemberVO findPw(MemberVO m) {
		return this.sqlSession.selectOne("findPw",m); //결과값 가져오기
	}
	
	//비밀번호 변경
	@Override
	public void updatePw(MemberVO m) {
		this.sqlSession.update("editPw",m);
	}

	//회원정보 불러오기
	@Override
	public MemberVO getMember(String m_id) {
		return this.sqlSession.selectOne("getMem",m_id);
	}
	
	//회원정보 수정
	@Override
	public void updateMember(MemberVO mem) {
		this.sqlSession.update("updMem",mem);
	}
	
	//로그인 시간기록
	@Override
	public void updateLoginDate(String m_id) {
		this.sqlSession.update("updLogDate",m_id);
	}

	//회원탈퇴처리
	@Override
	public void deleteMember(MemberVO mem) {
		this.sqlSession.update("delMem",mem);
	}
	
	
	
	
	
	
	
	

}
