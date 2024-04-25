package com.example.flownary.entity;

import java.time.LocalDateTime;

public class Follow {

	int fid;
	int uid;
	int fuid;
	LocalDateTime time;
	
	public Follow() {
	}
	
	public Follow(int fid, int uid, int fuid) {
		this.fid = fid;
		this.uid = uid;
		this.fuid = fuid;
	}
	
	public Follow(int fid, int uid, int fuid, LocalDateTime time) {
		this.fid = fid;
		this.uid = uid;
		this.fuid = fuid;
		this.time = time;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getFuid() {
		return fuid;
	}

	public void setFuid(int fuid) {
		this.fuid = fuid;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Follow [fid=" + fid + ", uid=" + uid + ", fuid=" + fuid + ", time=" + time + "]";
	}
	
}
