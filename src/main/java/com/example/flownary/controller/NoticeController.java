package com.example.flownary.controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flownary.entity.Notice;
import com.example.flownary.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class NoticeController {

	private final NoticeService nSvc;
	
	public void insertNotice(int uid, int type, int oid) {
		Notice notice = new Notice();
		notice.setOid(oid);
		notice.setUid(uid);
		notice.setType(type);
		
		nSvc.insertNotice(notice);
	}
	
	@GetMapping("/getNotice")
	public JSONArray getNoticeUid(@RequestParam int uid,
			@RequestParam(defaultValue="1", required=false) int type) {
		
		List<Notice> list = nSvc.getNoticeList(uid, type);
		
		JSONArray jArr = new JSONArray();
		
		for (Notice notice: list) {
			HashMap<String, Object> hMap = new HashMap<>();
			
			hMap.put("nid", notice.getNid());
			hMap.put("uid", notice.getUid());
			hMap.put("type", notice.getType());
			hMap.put("oid", notice.getOid());
			hMap.put("nContents", notice.getnContents());
			hMap.put("regTime", notice.getRegTime());
			
			JSONObject jObj = new JSONObject(hMap);
			jArr.add(jObj);
		}
		
		return jArr;
	}
	
	@GetMapping("/remove")
	public int removeNotice(@RequestParam int nid) {
		Notice notice = nSvc.getNotice(nid);
		
		if (notice == null)
		{
			return -1;
		}
		else
		{
			nSvc.removeNotice(nid);
		}
		
		return 0;
	}
}
