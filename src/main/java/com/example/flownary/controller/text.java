package com.example.flownary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class text {
	
	@GetMapping("/text")
	@ResponseBody
	public String helloWorld(Model model) {
		return "Hello world";
	}
	
	@GetMapping("/board/insert")
	public void boardinsert(@RequestParam String n)
	{
		System.out.println(n);
	}
}
