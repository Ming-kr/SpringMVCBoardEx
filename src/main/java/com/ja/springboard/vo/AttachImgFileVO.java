package com.ja.springboard.vo;

public class AttachImgFileVO {
	private String f_idx;
	private String c_idx;
	private String f_savedfilename;
	private String f_uploaddate;
	
	public AttachImgFileVO() {
		
	}

	public AttachImgFileVO(String f_idx, String c_idx, String f_savedfilename, String f_uploaddate) {
		super();
		this.f_idx = f_idx;
		this.c_idx = c_idx;
		this.f_savedfilename = f_savedfilename;
		this.f_uploaddate = f_uploaddate;
	}

	public String getF_idx() {
		return f_idx;
	}

	public void setF_idx(String f_idx) {
		this.f_idx = f_idx;
	}

	public String getC_idx() {
		return c_idx;
	}

	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}

	public String getF_savedfilename() {
		return f_savedfilename;
	}

	public void setF_savedfilename(String f_savedfilename) {
		this.f_savedfilename = f_savedfilename;
	}

	public String getF_uploaddate() {
		return f_uploaddate;
	}

	public void setF_uploaddate(String f_uploaddate) {
		this.f_uploaddate = f_uploaddate;
	}
	
		
}
