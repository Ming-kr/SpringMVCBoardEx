package com.ja.springboard.vo;

public class TestVO {
    private String t_idx;
    private String t_id;
    private String t_pw;
    private String t_nick;
    
    public TestVO() {
    	
    }

	public TestVO(String t_idx, String t_id, String t_pw, String t_nick) {
		super();
		this.t_idx = t_idx;
		this.t_id = t_id;
		this.t_pw = t_pw;
		this.t_nick = t_nick;
	}

	public String getT_idx() {
		return t_idx;
	}

	public void setT_idx(String t_idx) {
		this.t_idx = t_idx;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_pw() {
		return t_pw;
	}

	public void setT_pw(String t_pw) {
		this.t_pw = t_pw;
	}

	public String getT_nick() {
		return t_nick;
	}

	public void setT_nick(String t_nick) {
		this.t_nick = t_nick;
	}
	
    
    
}
