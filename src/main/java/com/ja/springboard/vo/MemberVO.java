package com.ja.springboard.vo;

public class MemberVO {
	private String m_idx;
	private String m_id;
	private String m_pw;
	private String m_nick;
	private String m_phone;
	private String m_joindate;
	
	public MemberVO() {
		
	}

	public MemberVO(String m_idx, String m_id, String m_pw, String m_nick, String m_phone, String m_joindate) {
		super();
		this.m_idx = m_idx;
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_nick = m_nick;
		this.m_phone = m_phone;
		this.m_joindate = m_joindate;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_joindate() {
		return m_joindate;
	}

	public void setM_joindate(String m_joindate) {
		this.m_joindate = m_joindate;
	}
	
	
	
}








