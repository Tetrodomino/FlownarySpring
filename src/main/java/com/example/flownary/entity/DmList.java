package com.example.flownary.entity;

import java.time.LocalDateTime;

public class DmList {

	int did;
	int uid;
	int cid;
	String dContents;
	LocalDateTime dTime;
	String dFile;
	int isDeleted;
	String nickname;
	
	public DmList() {
	}

	public DmList(int uid, int cid, String dContents) {
		this.uid = uid;
		this.cid = cid;
		this.dContents = dContents;
	}

	public DmList(int uid, int cid, String dContents, String dFile) {
		this.uid = uid;
		this.cid = cid;
		this.dContents = dContents;
		this.dFile = dFile;
	}

	public DmList(int did, int uid, int cid, String dContents, LocalDateTime dTime, String dFile, int isDeleted) {
		this.did = did;
		this.uid = uid;
		this.cid = cid;
		this.dContents = dContents;
		this.dTime = dTime;
		this.dFile = dFile;
		this.isDeleted = isDeleted;
	}

	public DmList(int did, int uid, int cid, String dContents, LocalDateTime dTime, String dFile, int isDeleted,
			String nickname) {
		this.did = did;
		this.uid = uid;
		this.cid = cid;
		this.dContents = dContents;
		this.dTime = dTime;
		this.dFile = dFile;
		this.isDeleted = isDeleted;
		this.nickname = nickname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getdContents() {
		return dContents;
	}

	public void setdContents(String dContents) {
		this.dContents = dContents;
	}

	public LocalDateTime getdTime() {
		return dTime;
	}

	public void setdTime(LocalDateTime dTime) {
		this.dTime = dTime;
	}

	public String getdFile() {
		return dFile;
	}

	public void setdFile(String dFile) {
		this.dFile = dFile;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "DmList [did=" + did + ", uid=" + uid + ", cid=" + cid + ", dContents=" + dContents + ", dTime=" + dTime
				+ ", dFile=" + dFile + ", isDeleted=" + isDeleted + ", nickname=" + nickname + "]";
	}
	
}
