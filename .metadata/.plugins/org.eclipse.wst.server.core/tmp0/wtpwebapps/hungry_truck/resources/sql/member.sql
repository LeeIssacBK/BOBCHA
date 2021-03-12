--회원 테이블 member 생성

create table member(
	m_no number(38) primary key, --회원 고유번호 
	m_id varchar2(50) not null, --아이디
	m_pw varchar2(100) not null, --비밀번호
	m_name varchar2(50) not null, --이름
	m_gender varchar2(50), --성별
	m_bir_yy number(38), --생년
	m_bir_mm number(38), --생월
	m_bir_dd number(38), --생일
	m_pho_1 varchar2(30), --휴대전화 1
	m_pho_2 varchar2(30), --휴대전화 2
	m_pho_3 varchar2(30), --휴대전화 3
	m_post varchar2(50), --우편번호
	m_addr_1 varchar2(100), --주소
	m_addr_2 varchar2(100), --참고항목
	m_addr_3 varchar2(100), --상세주소
	m_email_id varchar2(50), --이메일 아이디
	m_email_domain varchar2(50), --이메일 도메인
	m_profile varchar2(100), --프로필사진 저장소
	m_act number(38) default 1, --활성화 회원/탈퇴 회원 구분 추가
	m_auth varchar2(50) default '일반회원', --일반회원/관리자 구분 추가
	m_date date default sysdate, --레코드 생성날짜
	m_date_del date -- 탈퇴날짜
);


--컬럼 추가
alter table member add m_act number(38) default 1; --활성화 회원/탈퇴 회원 구분 추가
alter table member add m_auth varchar2(50) default '일반회원' --일반회원/관리자 구분 추가
alter table member add m_date date default sysdate; --레코드 생성날짜
alter table member add m_date_date date; -- 탈퇴날짜
alter table member add login_date date default sysdate; --로그인 시간
alter table member add del_cont varchar2(100); --탈퇴 사유
alter table member add b_count number(38) default 0; --글 개수

--생성된 테이블확인
select * from member;

--회원 고유번호 자동생성을 위한 시퀀스 생성
create sequence mem_seq
start with 1 
increment by 1
nocache;

insert into member values(
	mem_seq.nextval, 'admin', 'admin', '이병규', '남자', 1991, 2, 23, '010', '9854', '9911', '10130', '경기 김포시 고촌읍 수기로 136', ' (캐슬앤파밀리에시티 2단지)', '207동 1002호', 'qodrp', 'naver.com', '', 2, '관리자',sysdate
);

--일부 컬럼 자료형 수정
alter table member modify (
	m_pho_1 varchar2(30),
	m_pho_2 varchar2(30),
	m_pho_3 varchar2(30)
);

--오타난 컬럼명 수정
alter table member rename column m_date_date to m_date_del;
alter table member rename column del_cont to m_del_cont;

--특정 컬럼 날리기
alter table member drop column session_limit;
alter table member drop column session_key;
alter table member drop column b_count;

--특정 레코드 날리기
delete from member where m_no = 26;

--테이블 날리기
drop table member;

--레코드 전체 날리기
delete from member;

--MEMBER테이블의 자료형확인
SELECT COLUMN_NAME, DATA_TYPE FROM all_tab_columns where table_name='MEMBER';








