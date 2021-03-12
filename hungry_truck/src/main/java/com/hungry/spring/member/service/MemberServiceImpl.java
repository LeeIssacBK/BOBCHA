package com.hungry.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hungry.spring.member.dao.MemberDAO;
import com.hungry.spring.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	
	@Override
	public MemberVO id_check(String id) {
		return this.memberDao.id_check(id);
	}

	@Override
	public void insertMember(MemberVO m) {
		this.memberDao.insertMember(m);
	}

	@Override
	public MemberVO login_check(String m_id) {
		return this.memberDao.login_check(m_id);
	}

	@Override
	public List<MemberVO> findId(MemberVO m) {
		return this.memberDao.findId(m);
	}

	//AOP를 통한 트랜잭션 적용 - 반드시 조회가 완료된 회원만 비밀번호변경이 이루어 져야함.
	@Transactional
	@Override
	public MemberVO findPw(MemberVO m) {
		this.memberDao.updatePw(m);//임시비밀번호 변경
		return this.memberDao.findPw(m);//내용 가져오기
	}
	
	//회원정보 가져오기
	@Override
	public MemberVO getMember(String m_id) {
		return this.memberDao.getMember(m_id);
	}
	
	//회원정보 업데이트
	@Override
	public void updateMember(MemberVO mem) {
		this.memberDao.updateMember(mem);
	}

	//로그인 시간 업데이트
	@Override
	public void updateLoginDate(String m_id) {
		this.memberDao.updateLoginDate(m_id);
	}

	@Override
	public void deleteMember(MemberVO mem) {
		this.memberDao.deleteMember(mem);
	}
	
	
	
	
	
	
	

}
