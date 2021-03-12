--게시판 테이블 생성
create table board(
	b_no number(38) primary key, --글번호
	b_title varchar2(100) not null, --제목
	b_writer varchar2(100) not null, --작성자
	b_cont varchar2(4000) not null, --내용
	viewcnt number(38) default 0, --조회수
	regdate date default sysdate, --등록날짜
	reply_cnt number(38) default 0 --댓글개수
);

insert into board values(
	board_seq.nextval, '첫번째 제목', '작성자', '글내용', 0, sysdate, 0
);

--댓글테이블 생성
create table reply(
	r_no number(38) primary key, --댓글번호
	b_no number(38) default 0, --게시글 번호값
	replyer varchar2(20) not null,--댓글 작성자
	replytext varchar2(4000) not null, --댓글 내용
	regdate date, --등록날짜
	updatedate date --수정날짜
);

select * from reply;

--테이블 컬럼추가(회원 고유번호와 외래키 연결)
alter table reply add m_no number(38);
alter table board add m_no number(38);

--외래키 설정(글 <-> 회원)
alter table board 
add constraint board_mno_fk foreign key(m_no) references member(m_no);

--외래키 설정(댓글 <-> 회원)
alter table reply
add constraint reply_mno_fk foreign key(m_no) references member(m_no);

--댓글테이블과 board테이블의 댓글 개수를 일치하게함
update board
set reply_cnt = (select count(r_no) from reply where b_no = board.b_no)
where b_no > 0;

--외래키 설정(댓글 <-> 글)
alter table reply
add constraint reply_bno_fk foreign key(b_no) references board(b_no);

--댓글 번호생성위한 시퀀스 생성
create sequence reply_seq
start with 1
increment by 1
nocache;

--게시판 번호생성위한 시퀀스 생성
create sequence board_seq
start with 1
increment by 1
nocache;

--게시판 내용 확인
select * from board;

--댓글 내용 확인
select * from reply;



