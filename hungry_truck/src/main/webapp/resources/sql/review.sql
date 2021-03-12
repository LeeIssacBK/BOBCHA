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


delete from review;

select * from review;

create sequence rv_seq
start with 1
increment by 1
nocache;
