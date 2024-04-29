package com.example.flownary.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.flownary.entity.Setting;
import com.example.flownary.entity.User;
import com.example.flownary.service.SettingService;
import com.example.flownary.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired private UserService userSvc;
	@Autowired private SettingService setSvc;
	
	// 회원가입
	@GetMapping("/register")
	public void userRegister(@RequestParam String email, @RequestParam String pwd) {
		
		// 암호화 비밀번호 생성
		String hashedPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
		
		User user = new User();
		user.setEmail(email);
		user.setPwd(hashedPwd);
		userSvc.insertUser(user);
		
		user = userSvc.getUserEmail(email);
		
		// 유저 생성했으므로 1:1로 해당 유저의 Setting에 대한 정보도 생성 후 저장
		Setting set = new Setting();
		
		set.setUid(user.getUid());
		set.setTheme("default");
		
		setSvc.insertSetting(set);
	}
	
	// 회원정보 수정
	@GetMapping("/update")
	public void userUpdate(@RequestParam String uname, @RequestParam String nickname
			, @RequestParam String profile, @RequestParam String statusMessage
			, @RequestParam String snsDomain, @RequestParam int uid
			, @RequestParam LocalDate birth, String tel)
	{
		User user = new User();
		user.setUid(uid);
		user.setUname(uname);
		user.setNickname(nickname);
		user.setProfile(profile);
		user.setStatusMessage(statusMessage);
		user.setSnsDomain(snsDomain);
		user.setBirth(birth);
		user.setTel(tel);
		
		userSvc.updateUser(user);
	}
	
	@GetMapping("/updatepwd")
	public int userUpdate(@RequestParam int uid, @RequestParam String pwd1, @RequestParam String pwd2)
	{
		String pattern = "^(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{6,16}$";
		
		// 비밀번호 불일치
		if (!pwd1.equals(pwd2))
		{
			return 1;
		}
		
		// 비밀번호 길이 부족
		if (pwd1.length() < 6)
		{
			return 2;
		}
		
		// 숫자와 특수문자를 포함하지 않을 경우
		if (!Pattern.matches(pattern, pwd1))
		{
			return 3;
		}
		
		String hashedPwd = BCrypt.hashpw(pwd1, BCrypt.gensalt());
		User user = new User();
		user.setPwd(hashedPwd);
		user.setUid(uid);
		
		userSvc.updateUserPwd(user);
		
		// 성공
		return 0;
	}
	
	@GetMapping("/getUser")
	public JSONObject getUser(@RequestParam int uid)
	{
		User user = userSvc.getUser(uid);
		
		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("id", uid);
		hMap.put("email", user.getEmail());
		hMap.put("profile", user.getProfile());
		hMap.put("uname", user.getUname());
		hMap.put("nickname", user.getNickname());
		hMap.put("statusMessage", user.getStatusMessage());
		hMap.put("snsDomain", user.getSnsDomain());
		hMap.put("status", user.getStatus());
		hMap.put("regDate", user.getRegDate());
		hMap.put("gender", user.getGender());
		hMap.put("provider", user.getProvider());
		hMap.put("birth", user.getBirth());
		hMap.put("tel", user.getTel());
		hMap.put("hashUid", user.getHashUid());
		
		JSONObject userOut = new JSONObject(hMap);
		
		return userOut;
	}
	
	
}
