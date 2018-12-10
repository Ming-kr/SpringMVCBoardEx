package com.ja.springboard.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.springboard.vo.TestVO;

public interface TestSQLMapper {
	//$표시는 statement(정적)
	//#표시는 preparedStatement(동적)
	//먼저 정적으로 문자 만들고 동적으로 문자 생성...
	
	@Insert("INSERT INTO testtable VALUES(#{t_idx, jdbcType=INTEGER},#{t_id, jdbcType=VARCHAR},#{t_pw},#{t_nick})")         
	public void insert(TestVO vo);

	@Insert("INSERT INTO testtable VALUES(#{t_idx, jdbcType=INTEGER},#{t_id, jdbcType=VARCHAR},#{t_pw},#{t_nick})")         
	public void insertHashMap(HashMap<String,String> vo);
	
	@Select("SELECT * FROM testtable")
	public ArrayList<TestVO> select();
	
	@Select("SELECT * FROM testtable")
	public ArrayList<HashMap<String,String>> selectHashMap();
}
