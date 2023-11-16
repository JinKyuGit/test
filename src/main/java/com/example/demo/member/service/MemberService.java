package com.example.demo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.SHA256;
import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public String loginProcess(MemberVo param) throws Exception {
		
		String result = "00"; //성공
		
		String password = SHA256.encrypt(param.getUserPassword());
		
		// 아이디로만 조회. - 비밀번호 암호화 후 비교.
		MemberVo vo = memberMapper.selectMember(param);
		
		if(null == vo) {
			result = "01"; // 아이디 없음. 
		}else {
			if(!password.equals(vo.getUserPassword())) {
				result = "02"; // 비밀번호 오류. 
			}
		}
		
		return result;
	}
	
	public String dupCheckId(MemberVo param) throws Exception {
		
		String result ="00"; //성공
		
		//아이디로 조회.
		MemberVo vo = memberMapper.selectMember(param);
		
		if(null != vo) {
			result = "01"; // 중복 존재.
		}
		
		return result;
		
	}
	
	//회원 가입.
	public String insertMember(MemberVo param) throws Exception {
		
		String result = "00";
		
		//비밀번호 암호화
		param.setUserPassword(SHA256.encrypt(param.getUserPassword()));
		int cnt = 0;
		
		try {
			cnt = memberMapper.insertMember(param);
		}catch(Exception e) {
			result = "01";
		}
		
		if(cnt == 0) {
			result = "01"; 
		}
		
		return result;
		
	}

	public String updateMember(MemberVo param) throws Exception {
		
		String result = "00";
			
		//이전 비밀번호 검증
		String password = SHA256.encrypt(param.getUserPassword());
		
		// 아이디로만 조회. - 비밀번호 암호화 후 비교.
		MemberVo vo = memberMapper.selectMember(param);
		
		if(!password.equals(vo.getUserPassword())) {
			result = "01"; // 비밀번호 오류.
			return result;
		}
		
		//업데이트
		param.setUserPassword(SHA256.encrypt(param.getUserPassword()));
		int cnt = 0;
		
		try {
			cnt = memberMapper.updateMember(param);
		}catch(Exception e) {
			result = "02";
		}
		
		if(cnt == 0) {
			result = "02"; 
		}
		
		return result;
	}

}
