package com.example.flownary.entity;

import java.time.LocalDateTime;

public class Re_Reply {

	int rrid;
	int rid;
	int uid;
	String rrContents;
	LocalDateTime modTime;
	int likeCount;
	String nickname;
	int isDeleted;
	
	public Re_Reply() {
	}

	public Re_Reply(int rid, int uid, String rrContents) {
		this.rid = rid;
		this.uid = uid;
		this.rrContents = rrContents;
	}

	public Re_Reply(int rid, int uid, String rrContents, String nickname) {
		this.rid = rid;
		this.uid = uid;
		this.rrContents = rrContents;
		this.nickname = nickname;
	}

	public Re_Reply(int rid, int rrid, int uid, String rrContents, LocalDateTime modTime, int isDeleted) {
		this.rid = rid;
		this.rrid = rrid;
		this.uid = uid;
		this.rrContents = rrContents;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
	}

	public Re_Reply(int rid, int rrid, int uid, String rrContents, LocalDateTime modTime, int isDeleted,
			String nickname) {
		this.rrid = rrid;
		this.rid = rid;
		this.uid = uid;
		this.rrContents = rrContents;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.nickname = nickname;
	}

	public Re_Reply(int rrid, int rid, int uid, String rrContents, LocalDateTime modTime, int likeCount,
			String nickname, int isDeleted) {
		this.rrid = rrid;
		this.rid = rid;
		this.uid = uid;
		this.rrContents = rrContents;
		this.modTime = modTime;
		this.likeCount = likeCount;
		this.nickname = nickname;
		this.isDeleted = isDeleted;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRrid() {
		return rrid;
	}

	public void setRrid(int rrid) {
		this.rrid = rrid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getRrContents() {
		return rrContents;
	}

	public void setRrContents(String rrContents) {
		this.rrContents = rrContents;
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

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		return "Re_Reply [rid=" + rid + ", rrid=" + rrid + ", uid=" + uid + ", rrContents=" + rrContents + ", modTime="
				+ modTime + ", isDeleted=" + isDeleted + ", nickname=" + nickname + "]";
	}
	
}
