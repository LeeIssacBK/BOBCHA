--방문자 테이블 생성
create table visit (v_date date not null);

--임시 데이터 삽입
INSERT INTO VISIT (V_DATE) VALUES ( TO_DATE('10-06-2016','MM-DD-YYYY') );

--삽입된 내용 확인
select * from visit;



