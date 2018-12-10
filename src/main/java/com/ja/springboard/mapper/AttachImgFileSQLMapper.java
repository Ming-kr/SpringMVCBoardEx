package com.ja.springboard.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.ja.springboard.vo.AttachImgFileVO;

public interface AttachImgFileSQLMapper {
	@Insert("INSERT INTO attachimgfile_1023 VALUES(seq_attachimgfile_idx.nextval,#{c_idx},#{f_savedfilename},SYSDATE)")
	public void insert(AttachImgFileVO vo);
	
	@Select("SELECT * FROM attachimgfile_1023 WHERE c_idx=#{c_idx}")
	public ArrayList<AttachImgFileVO> selectByC_idx(String c_idx);
}
