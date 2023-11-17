package com.example.demo.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.member.service.MemberService;
import com.example.demo.member.vo.MemberVo;


@RestController
public class MemberController {
	
	@Autowired 
	private MemberService memberService;
	
	@PostMapping("/memberLogin")
	public Map<String, Object> memberLogin(@RequestBody MemberVo param) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("result", memberService.loginProcess(param));
		
		
		return resultMap;
	}
	
	@PostMapping("/dupCheckId")
	public Map<String, Object> dupCheckId(@RequestBody MemberVo param) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("result", memberService.dupCheckId(param));
		
		return resultMap;
	}
	
	@PostMapping("/insertMember")
	public Map<String, Object> insertMember(@RequestBody MemberVo param) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("result", memberService.insertMember(param));
		
		return resultMap;
	}
	
	@PostMapping("updateMember")
	public Map<String, Object> updateMember(@RequestBody MemberVo param) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("result", memberService.updateMember(param));
		
		return resultMap;
	}
	
	@PostMapping("/encrypt")
	public Map<String, Object> encrypt(@RequestBody MemberVo param) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<>();
		
		resultMap.put("result", memberService.encrypt(param.getUserPassword()));
		
		return resultMap;
	}
	
	
	
	
	
	

}
