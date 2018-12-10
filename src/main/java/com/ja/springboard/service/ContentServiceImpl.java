package com.ja.springboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ja.springboard.mapper.AttachImgFileSQLMapper;
import com.ja.springboard.mapper.ContentSQLMapper;
import com.ja.springboard.mapper.MemberSQLMapper;
import com.ja.springboard.vo.*;

@Service
public class ContentServiceImpl implements ContentService{
	
	@Autowired
	MemberSQLMapper memberSQLMapper;
	@Autowired
	ContentSQLMapper contentSQLMapper;
	@Autowired
	AttachImgFileSQLMapper attachImgFileSQLMapper;
	
	@Override
	public ArrayList<BoardDataVO> getContentList() {
		ArrayList<BoardDataVO> boardDataList = 
				new ArrayList<BoardDataVO>(); 
		
		ArrayList<ContentVO> contentList = 
				contentSQLMapper.selectAll();
		
		for(ContentVO content : contentList) {
			MemberVO memberVO = 
			memberSQLMapper.selectByIdx(content.getM_idx());
			
			boardDataList.add(new BoardDataVO(memberVO,content));
		}
		return boardDataList;
	}

	@Override
	@Transactional
	public void writeContent(ContentVO requestContentVO , ArrayList<AttachImgFileVO> fileDataList) {
		//키 (증가된 c_idx)를 가져오고..
		String c_idx = contentSQLMapper.selectKey();
		requestContentVO.setC_idx(c_idx);
		
		contentSQLMapper.insert(requestContentVO);
		
		//반복문을 돌면서...
		for(AttachImgFileVO fileVO : fileDataList) {
			//fileVO.setC_idx("aaa"); //트랜젝션 처리 테스트
			fileVO.setC_idx(c_idx);
			//DB에 저장..
			attachImgFileSQLMapper.insert(fileVO);
		}
	}

	@Override
	public BoardDataVO getContent(ContentVO requestContentVO) {
		ContentVO contentVO = 
				contentSQLMapper.selectByIdx(requestContentVO);
		
		MemberVO memberVO = 
				memberSQLMapper.selectByIdx(contentVO.getM_idx());
		
		ArrayList<AttachImgFileVO> fileList = 
				attachImgFileSQLMapper.selectByC_idx(contentVO.getC_idx());
		
		return new BoardDataVO(memberVO,contentVO,fileList);
	}

	@Override
	public void deleteContent(ContentVO requestContentVO) {
		contentSQLMapper.deleteByIdx(requestContentVO);
		
	}

	@Override
	public void updateContent(ContentVO requestContentVO) {
		contentSQLMapper.update(requestContentVO);
	}

}
