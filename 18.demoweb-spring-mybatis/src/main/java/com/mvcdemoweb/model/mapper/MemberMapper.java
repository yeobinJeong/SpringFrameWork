package com.mvcdemoweb.model.mapper;

import java.util.HashMap;
import java.util.List;

import com.mvcdemoweb.model.dto.Member;

public interface MemberMapper {

	void insertMember(Member member);
	List<Member> selectMembers();
	Member selectMemberById(String memberId);
	Member selectMemberByIdAndPasswd(
		HashMap<String, Object> params);
	
}



