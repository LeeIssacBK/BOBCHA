--찜하기 테이블 생성
create table dibs(
	dibs_no int primary key,
	rv_no int not null,
	rv_title varchar2(100) not null,
	m_id varchar2(100) not null,
	dibs_check int default 0 not null
);

select * from dibs order by dibs_no desc;
delete from dibs;
drop table dibs;

create sequence dibs_seq
start with 1

increment by 1
nocache;

delete from dibs a where ROWID < (select MAX(ROWID) from dibs b where a.rv_no = b.rv_no and a.m_id = b.m_id);


select * from review where rv_no in (select distinct rv_no from dibs where m_id='ssss') order by ROWNUM desc;












