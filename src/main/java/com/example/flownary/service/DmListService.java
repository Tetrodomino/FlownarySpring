package com.example.flownary.service;

import java.util.List;

import com.example.flownary.entity.DmList;

public interface DmListService {

	DmList getDmList(int did);
	
	int getDmListCid(int did);
	
	String getDmListLast(int cid);
	
	List<DmList> getDmListList(int cid, int count);
	
	List<Integer> getDidList(int cid);
	
	List<DmList> getDmListListByUid(int uid, int count);
	
	int insertDmList(DmList dmList);
	
	void deleteDmList(int did);
}
