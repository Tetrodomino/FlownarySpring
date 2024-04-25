package com.example.flownary.entity;

import java.time.LocalDateTime;

public class Like_ {

	int lid;
	int uid;
	int fuid;
	int type;
	int oid;
	LocalDateTime time;
	int stat;
	
	public Like_() {
	}

	public Like_(int lid, int uid, int fuid, int type, int oid) {
		this.lid = lid;
		this.uid = uid;
		this.fuid = fuid;
		this.type = type;
		this.oid = oid;
	}

	public Like_(int lid, int uid, int fuid, int type, int oid, LocalDateTime time, int stat) {
		this.lid = lid;
		this.uid = uid;
		this.fuid = fuid;
		this.type = type;
		this.oid = oid;
		this.time = time;
		this.stat = stat;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "Like_ [lid=" + lid + ", uid=" + uid + ", fuid=" + fuid + ", type=" + type + ", oid=" + oid + ", time="
				+ time + ", stat=" + stat + "]";
	}
	
}
