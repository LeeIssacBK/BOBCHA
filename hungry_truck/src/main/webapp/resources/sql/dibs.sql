--찜하기 테이블 생성
create table dibs(
	dibs_no int primary key,
	rv_no int not null,
	rv_title varchar2(100) not null,
	m_id varchar2(100) not null,
	dibs_check int default 0 not null
);

select * from dibs;

drop table dibs;