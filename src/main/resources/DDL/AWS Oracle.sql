DROP TABLE member_1023;
DROP TABLE content_1023;
DROP TABLE attachimgfile_1023;

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


CREATE TABLE attachimgfile_1023(
    f_idx NUMBER(10),
    c_idx NUMBER(10),
    f_savedfilename VARCHAR2(200),
    f_uploaddate DATE
);

CREATE SEQUENCE seq_attachimgfile_idx;

CREATE SEQUENCE seq_member_idx;
CREATE SEQUENCE seq_content_idx;


SELECT * FROM member_1023;


--------------안드로이드 레코드-------------

DROP TABLE baseballrecode;

CREATE TABLE baseballrecode(
    bbr_idx NUMBER(8),
    bbr_nick VARCHAR2(20),
    bbr_content VARCHAR2(100),
    bbr_trycount NUMBER(8),
    bbr_trytime NUMBER(8),
    bbr_joindate DATE
);

CREATE SEQUENCE seq_baseballrecode_idx;

SELECT * FROM baseballrecode;


