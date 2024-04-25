package com.example.flownary.entity;

public class Setting {

	int uid;
	String theme;
	int accountEnableUnable;
	int fontSize;
	String blackList;
	
	public Setting() {
	}

	public Setting(int uid, String theme, int accountEnableUnable, int fontSize) {
		this.uid = uid;
		this.theme = theme;
		this.accountEnableUnable = accountEnableUnable;
		this.fontSize = fontSize;
	}

	public Setting(int uid, String theme, int accountEnableUnable, int fontSize, String blackList) {
		this.uid = uid;
		this.theme = theme;
		this.accountEnableUnable = accountEnableUnable;
		this.fontSize = fontSize;
		this.blackList = blackList;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getAccountEnableUnable() {
		return accountEnableUnable;
	}

	public void setAccountEnableUnable(int accountEnableUnable) {
		this.accountEnableUnable = accountEnableUnable;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getBlackList() {
		return blackList;
	}

	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}

	@Override
	public String toString() {
		return "Setting [uid=" + uid + ", theme=" + theme + ", accountEnableUnable=" + accountEnableUnable
				+ ", fontSize=" + fontSize + ", blackList=" + blackList + "]";
	}
	
}
