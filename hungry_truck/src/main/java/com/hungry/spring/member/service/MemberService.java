package com.hungry.spring.member.service;


import java.util.List;

import com.hungry.spring.member.vo.MemberVO;

public interface MemberService {
	
	//ID중복검사
	MemberVO id_check(String id);

	//회원정보 INSERT
	void insertMember(MemberVO m);

	//로그인 체크
	MemberVO login_check(String m_id);
	
	//아이디 찾기
	List<MemberVO> findId(MemberVO m);
	
	//비밀번호 찾기
	MemberVO findPw(MemberVO m);
	
	//회원정보 불러오기
	MemberVO getMember(String m_id);
	
	//회원정보 수정
	void updateMember(MemberVO mem);
	
	//로그인시간 업데이트
	void updateLoginDate(String m_id);
	
	//회원탈퇴
	void deleteMember(MemberVO mem);
	

}
