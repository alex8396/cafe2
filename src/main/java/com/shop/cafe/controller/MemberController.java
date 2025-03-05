package com.shop.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Member;
import com.shop.cafe.service.MemberService;

@RestController
@CrossOrigin("http://192.168.219.109:5503/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("insertMember")
	public Map<String, String> insertMember(@RequestBody Member m) {
		System.out.println(m);
		Map<String, String> responseData = new HashMap();
		try {
			memberService.insertMember(m);
			responseData.put("msg", "ok");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			responseData.put("msg", e.getMessage());
		}
		return responseData;
	}

}
