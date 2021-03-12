package com.hungry.spring.member.dao;


import java.util.List;

import com.hungry.spring.member.vo.MemberVO;

public interface MemberDAO {
	
	public MemberVO id_check(String id);
	
	public void insertMember(MemberVO m);
	
	public MemberVO login_check(String m_id);

	public List<MemberVO> findId(MemberVO m);

	public MemberVO findPw(MemberVO m);

	public void updatePw(MemberVO m);

	public MemberVO getMember(String m_id);

	public void updateMember(MemberVO mem);

	public void updateLoginDate(String m_id);

	public void deleteMember(MemberVO mem);
	
	

}
