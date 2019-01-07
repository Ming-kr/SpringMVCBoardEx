package com.ja.springboard.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ja.springboard.vo.TestVO;



public interface TestSQLMapper {
	// $표시는 statement(정적)
	// #표시는 preparedStatement(동적)
	// 먼저 정적으로 문자 만들고 동적으로 문자 생성...

	@Insert("INSERT INTO testtable VALUES(#{t_idx, jdbcType=INTEGER},#{t_id, jdbcType=VARCHAR},#{t_pw},#{t_nick})")
	public void insert(TestVO vo);

	@Insert("INSERT INTO testtable VALUES(#{t_idx, jdbcType=INTEGER},#{t_id, jdbcType=VARCHAR},#{t_pw},#{t_nick})")
	public void insertHashMap(HashMap<String, String> vo);

	@Select("SELECT * FROM testtable")
	public ArrayList<TestVO> select();

	//@Select("SELECT t_id FROM testtable WHERE t_id IN(${test})")
	@Select("SELECT testtable.t_nick FROM testtable,testtable2 WHERE testtable.t_id IN(${test}) AND testtable.t_id = testtable2.t_id")
	//@ResultType(java.lang.String.class)
	public ArrayList<String> selectId(@Param("test") String test);
	
	
	@Select("SELECT * FROM testtable")
	public ArrayList<HashMap<String, String>> selectHashMap();

	@SelectProvider(type = com.ja.springboard.mapper.TestSQLBuilder.class ,method = "selectInTest")
	public ArrayList<TestVO> selectIn(@Param("listT_id") ArrayList<String> listT_id);
	
	//매개변수 @Param("id") String m_id , @Param("pw") String m_pw 로 여러 값 받을 수 있음
	//객체 변수도 여러 값 받을 수 있나???.... 가능!!
	//@Param("rule")ControlRuleTable rule
	//#{rule.control_date}
	//http://g1soft.kr/220858344769
		
}









