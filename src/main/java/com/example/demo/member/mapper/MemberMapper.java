package com.example.demo.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.member.vo.MemberVo;

@Mapper
public interface MemberMapper {
	
	public MemberVo selectMember(MemberVo param) throws Exception;
	
	public int insertMember(MemberVo param) throws Exception;
	
	public int updateMember(MemberVo param) throws Exception;
	
}
