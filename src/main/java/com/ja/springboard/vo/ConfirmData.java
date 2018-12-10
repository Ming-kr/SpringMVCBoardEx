package com.ja.springboard.vo;

public class ConfirmData {
	
	private boolean isExistID;
	
	public ConfirmData() {
		
	}

	public ConfirmData(boolean isExistID) {
		super();
		this.isExistID = isExistID;
	}

	public boolean isExistID() {
		return isExistID;
	}

	public void setExistID(boolean isExistID) {
		this.isExistID = isExistID;
	}
	
	
	
	
}
