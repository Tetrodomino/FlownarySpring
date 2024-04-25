package com.example.flownary.entity;

import java.time.LocalDateTime;

public class Notice {

	int nid;
	int uid;
	int type;
	int oid;
	String nContents;
	LocalDateTime regTime;
	int onOff;
	
	public Notice() {
	}

	public Notice(int nid, int uid, int type, int oid) {
		this.nid = nid;
		this.uid = uid;
		this.type = type;
		this.oid = oid;
	}

	public Notice(int nid, int uid, int type, int oid, String nContents) {
		this.nid = nid;
		this.uid = uid;
		this.type = type;
		this.oid = oid;
		this.nContents = nContents;
	}

	public Notice(int nid, int uid, int type, int oid, String nContents, LocalDateTime regTime, int onOff) {
		this.nid = nid;
		this.uid = uid;
		this.type = type;
		this.oid = oid;
		this.nContents = nContents;
		this.regTime = regTime;
		this.onOff = onOff;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getnContents() {
		return nContents;
	}

	public void setnContents(String nContents) {
		this.nContents = nContents;
	}

	public LocalDateTime getRegTime() {
		return regTime;
	}

	public void setRegTime(LocalDateTime regTime) {
		this.regTime = regTime;
	}

	public int getOnOff() {
		return onOff;
	}

	public void setOnOff(int onOff) {
		this.onOff = onOff;
	}

	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", uid=" + uid + ", type=" + type + ", oid=" + oid + ", nContents=" + nContents
				+ ", regTime=" + regTime + ", onOff=" + onOff + "]";
	}
	
}
