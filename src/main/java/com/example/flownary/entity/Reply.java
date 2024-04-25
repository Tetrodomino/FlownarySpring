package com.example.flownary.entity;

import java.time.LocalDateTime;

public class Reply {

	int rid;
	int bid;
	int uid;
	String rContents;
	LocalDateTime modTime;
	int isDeleted;
	String nickname;
	
	public Reply() {
	}

	public Reply(int uid, String rContents) {
		this.uid = uid;
		this.rContents = rContents;
	}

	public Reply(int bid, int uid, String rContents) {
		this.bid = bid;
		this.uid = uid;
		this.rContents = rContents;
	}

	public Reply(int rid, int bid, int uid, String rContents, LocalDateTime modTime, int isDeleted) {
		this.rid = rid;
		this.bid = bid;
		this.uid = uid;
		this.rContents = rContents;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
	}

	public Reply(int rid, int bid, int uid, String rContents, LocalDateTime modTime, int isDeleted, String nickname) {
		this.rid = rid;
		this.bid = bid;
		this.uid = uid;
		this.rContents = rContents;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.nickname = nickname;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getrContents() {
		return rContents;
	}

	public void setrContents(String rContents) {
		this.rContents = rContents;
	}

	public LocalDateTime getModTime() {
		return modTime;
	}

	public void setModTime(LocalDateTime modTime) {
		this.modTime = modTime;
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
		return "Reply [rid=" + rid + ", bid=" + bid + ", uid=" + uid + ", rContents=" + rContents + ", modTime="
				+ modTime + ", isDeleted=" + isDeleted + ", nickname=" + nickname + "]";
	}
}
