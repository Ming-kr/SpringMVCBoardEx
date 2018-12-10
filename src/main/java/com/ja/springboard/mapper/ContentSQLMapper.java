package com.ja.springboard.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.*;
import com.ja.springboard.vo.ContentVO;

public interface ContentSQLMapper {
	
	@Select("SELECT seq_content_idx.nextval FROM dual")
	public String selectKey();
	
	@Select("SELECT * FROM content_1023 WHERE c_idx=#{c_idx}")
	public ContentVO selectByIdx(ContentVO vo);
	
	@Select("SELECT * FROM content_1023 ORDER BY c_idx DESC")
	public ArrayList<ContentVO> selectAll();
	
	@Insert("INSERT INTO content_1023 VALUES(#{c_idx},#{m_idx},#{c_title},#{c_content},SYSDATE)")
	public void insert(ContentVO vo);
	
	@Update("UPDATE content_1023 SET c_title=#{c_title},c_content=#{c_content} WHERE c_idx=#{c_idx}")
	public void update(ContentVO vo);
	
	@Delete("DELETE FROM content_1023 WHERE c_idx=#{c_idx}")
	public void deleteByIdx(ContentVO vo);
	
	
	
}





