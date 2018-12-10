package com.ja.springboard.mapper;

import org.apache.ibatis.annotations.*;

import com.ja.springboard.vo.MemberVO;

public interface MemberSQLMapper {
	
	//$표시는 statement(정적)
	//#표시는 preparedStatement(동적)
	//먼저 정적으로 문자 만들고 동적으로 문자 생성...
	
	@Insert("INSERT INTO member_1023 VALUES(seq_member_idx.nextval,#{m_id},#{m_pw},#{m_nick},#{m_phone},SYSDATE)")         
	public void insert(MemberVO vo);
	
	@Select("SELECT * FROM member_1023 WHERE m_id=#{m_id}")
	public MemberVO selectById(MemberVO vo);
	
	@Select("SELECT * FROM member_1023 WHERE m_idx=#{m_idx}")
	public MemberVO selectByIdx(String m_idx);
}












