--리뷰 테이블 생성
create table review(
	rv_no number(38) primary key, --리뷰고유번호
	rv_title varchar2(100), --가게명
	rv_writer varchar2(100), --작성자
	rv_content varchar2(4000), --내용
	rv_price varchar2(500), --가격정보
	rv_days varchar2(100), --출몰날짜
	rv_times varchar2(50), --출몰시간
	rv_rating number(10), --평점
	rv_image_file varchar2(1000), --가게사진
	rv_lat varchar2(100), --위도
	rv_lng varchar2(100), --경도
	rv_date date, --생성일
	rv_update date --수정일
);

alter table review add rvr_count number(38) default 0;

delete from review;

select * from review order by rv_no desc;

create sequence rv_seq
start with 1
increment by 1
nocache;


--밥차 댓글 테이블 생성
create table rv_reply(
	rvr_no number(38) primary key, --댓글번호
	rv_no number(38) default 0, --밥차 번호값
	rvr_rating number(10), --평점
	rvr_replyer varchar2(20) not null, --댓글 작성자
	rvr_replytext varchar2(1000) not null, --댓글 내용
	rvr_regdate date, --등록날짜
	rvr_updatedate date --수정날짜
);

select * from rv_reply order by rvr_no desc;

--외래키 설정(밥차리뷰 <-> 댓글리뷰)
alter table rv_reply
add constraint review_rv_no_fk foreign key(rv_no) references review(rv_no);

--제약조건 비활성화
alter table rv_reply disable constraint review_rv_no_fk;

create sequence rvr_seq
start with 1
increment by 1
nocache;


