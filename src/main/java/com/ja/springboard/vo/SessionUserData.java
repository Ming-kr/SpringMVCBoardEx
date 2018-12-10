package com.ja.springboard.vo;

public class SessionUserData {
	private String m_idx;
	private String m_nick;
	
	public SessionUserData(){
		
	}
	
	public SessionUserData(String m_idx, String m_nick) {
		super();
		this.m_idx = m_idx;
		this.m_nick = m_nick;
	}
	public String getM_idx() {
		return m_idx;
	}
	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_nick() {
		return m_nick;
	}
	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}
	
	
}
