package com.ja.springboard.vo;

import java.util.ArrayList;

public class BoardDataVO {
	private MemberVO member;
	private ContentVO content;
	private ArrayList<AttachImgFileVO> fileList;
	
	public BoardDataVO() {
		
	}

	
	
	public BoardDataVO(MemberVO member, ContentVO content) {
		super();
		this.member = member;
		this.content = content;
	}



	public BoardDataVO(MemberVO member, ContentVO content, ArrayList<AttachImgFileVO> fileList) {
		super();
		this.member = member;
		this.content = content;
		this.fileList = fileList;
	}


	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}

	public ContentVO getContent() {
		return content;
	}

	public void setContent(ContentVO content) {
		this.content = content;
	}

	public ArrayList<AttachImgFileVO> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<AttachImgFileVO> fileList) {
		this.fileList = fileList;
	}
	
	
	
	
	
}





