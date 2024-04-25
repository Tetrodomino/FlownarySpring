package com.example.flownary.entity;

import java.time.LocalDate;

public class User {

	int uid;
	String email;
	String pwd;
	String profile;
	String uname;
	String nickname;
	String statusMessage;
	String snsDomain;
	int status;
	LocalDate regDate;
	
	public User() {
	}

	public User(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	public User(int uid) {
		this.uid = uid;
	}

	public User(int uid, String email, String pwd, int status, LocalDate regDate) {
		this.uid = uid;
		this.email = email;
		this.pwd = pwd;
		this.status = status;
		this.regDate = regDate;
	}

	public User(int uid, String email, String pwd, String profile, String uname, String nickname, String statusMessage,
			String snsDomain, int status, LocalDate regDate) {
		this.uid = uid;
		this.email = email;
		this.pwd = pwd;
		this.profile = profile;
		this.uname = uname;
		this.nickname = nickname;
		this.statusMessage = statusMessage;
		this.snsDomain = snsDomain;
		this.status = status;
		this.regDate = regDate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getSnsDomain() {
		return snsDomain;
	}

	public void setSnsDomain(String snsDomain) {
		this.snsDomain = snsDomain;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", pwd=" + pwd + ", profile=" + profile + ", uname=" + uname
				+ ", nickname=" + nickname + ", statusMessage=" + statusMessage + ", snsDomain=" + snsDomain
				+ ", status=" + status + ", regDate=" + regDate + "]";
	}
}
