package com.example.flownary.entity;

public class Chat {

	int cid;
	int uid1;
	int uid2;
	
	public Chat() {
	}

	public Chat(int cid, int uid1, int uid2) {
		this.cid = cid;
		this.uid1 = uid1;
		this.uid2 = uid2;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid1() {
		return uid1;
	}

	public void setUid1(int uid1) {
		this.uid1 = uid1;
	}

	public int getUid2() {
		return uid2;
	}

	public void setUid2(int uid2) {
		this.uid2 = uid2;
	}

	@Override
	public String toString() {
		return "Chat [cid=" + cid + ", uid1=" + uid1 + ", uid2=" + uid2 + "]";
	}
	
}
