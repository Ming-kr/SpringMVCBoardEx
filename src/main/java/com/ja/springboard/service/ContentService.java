package com.ja.springboard.service;

import java.util.ArrayList;

import com.ja.springboard.vo.*;

public interface ContentService {
	
	public ArrayList<BoardDataVO> getContentList();
	public void writeContent(ContentVO requestContentVO , ArrayList<AttachImgFileVO> fileDataList);
	public BoardDataVO getContent(ContentVO requestContentVO);
	public void deleteContent(ContentVO requestContentVO);
	public void updateContent(ContentVO requestContentVO);
	
}













