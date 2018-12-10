SELECT 1 FROM member_1023;

DROP TABLE member_1023;
DROP TABLE content_1023;


CREATE TABLE member_1023(
    m_idx NUMBER(5),
    m_id VARCHAR2(20),
    m_pw VARCHAR2(80),
    m_nick VARCHAR2(20),
    m_phone VARCHAR2(40),
    m_joindate DATE
);

CREATE TABLE content_1023(
    c_idx NUMBER(10),
    m_idx NUMBER(5),
    c_title VARCHAR2(100),
    c_content VARCHAR2(500),
    c_writedate DATE
);

DROP TABLE attachimgfile_1023;

CREATE TABLE attachimgfile_1023(
    f_idx NUMBER(10),
    c_idx NUMBER(10),
    f_savedfilename VARCHAR2(200),
    f_uploaddate DATE
);

SELECT * FROM attachimgfile_1023;

CREATE SEQUENCE seq_attachimgfile_idx;

CREATE SEQUENCE seq_member_idx;
CREATE SEQUENCE seq_content_idx;



INSERT INTO member_1023 
VALUES(seq_member_idx.nextval , '1111' , '1111' , '한조' , '01047612103' , SYSDATE);

SELECT * FROM member_1023 WHERE m_id = 's001' AND m_pw = '1111';

commit;
INSERT INTO content_1023 
VALUES(seq_content_idx.nextval , 2 , '안녕하세요' , '비가 옵니다' , SYSDATE);

SELECT * FROM attachimgfile_1023;
SELECT * FROM content_1023 ORDER BY c_idx DESC;
SELECT * FROM member_1023;

SELECT * FROM member_1023 ORDER BY M_IDX DESC;
UPDATE member_1023 SET m_idx = m_idx + 1;


SELECT * FROM content_1023,member_1023 WHERE content_1023.m_idx = member_1023.m_idx;



SELECT * FROM content_1023 c,member_1023 m WHERE c.m_idx = m.m_idx ORDER BY c_idx DESC;



DELETE FROM content_1023 WHERE c_idx = 15;

commit;


SELECT * FROM content_1023 ;

UPDATE content_1023 SET C_TITLE = 'aaaaa' ,C_CONTENT = 'afeaf' WHERE c_idx = 16;


SELECT * FROM  
(SELECT member_1023.m_nick, content_1023.*, 
ROWNUM AS rnum  
FROM content_1023 , member_1023 
WHERE content_1023.m_idx = member_1023.m_idx)  
where rnum between 1 and 10;


SELECT member_1023.m_nick, content_1023.*, 
ROWNUM AS rnum  
FROM content_1023 , member_1023 
WHERE content_1023.m_idx = member_1023.m_idx;


SELECT member_1023.m_nick, content_1023.*, 
ROWNUM AS rnum  
FROM content_1023 , member_1023 
WHERE content_1023.m_idx = member_1023.m_idx;



SELECT * FROM  
(SELECT member_1023.m_nick, content_1023.*, 
ROWNUM AS rnum  
FROM content_1023 , member_1023 
WHERE content_1023.m_idx = member_1023.m_idx)  
where rnum between 1 and 10;


SELECT member_1023.m_nick, content_1023.*, 
ROWNUM AS rnum  
FROM content_1023 , member_1023 
WHERE content_1023.m_idx = member_1023.m_idx ORDER BY content_1023.c_idx DESC;

SELECT * FROM 
(SELECT 
    content_1023.*,
    row_number() over(order by c_idx desc)  rnum 
FROM content_1023) 
where rnum between 1 and 10;




SELECT member_1023.m_nick, content_1023.*, ROWNUM AS rnum  
FROM content_1023 , member_1023 
WHERE content_1023.m_idx = member_1023.m_idx;


SELECT content_1023.c_title , ROWNUM AS aaaa FROM content_1023 ;

SELECT * FROM content_1023;
commit;


INSERT INTO content_1023 VALUES(1,1,'111','2222','2018-07-08');


INSERT INTO content_1023 VALUES(seq_content_idx.nextval,1,'1','1','2018-11-12');


SELECT seq_member_idx.nextval FROM dual;
SELECT seq_member_idx.currval FROM dual;



INSERT INTO content_1023 VALUES(seq_content_idx,7,'sasa','asdadada',SYSDATE);

SELECT * FROM content_1023;

INSERT INTO member_1023 VALUES(10,'s011','qweqwe','한조','12313',SYSDATE);
commit;


SELECT MAX(c_idx) FROM content_1023;

SELECT seq_member_idx.nextval FROM dual;








