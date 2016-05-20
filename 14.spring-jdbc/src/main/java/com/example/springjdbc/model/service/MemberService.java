package com.example.springjdbc.model.service;

import java.util.List;

import com.example.springjdbc.model.dto.Member;

public interface MemberService {

	void registerMember(Member member);

	List<Member> getAllMembers();

	Member searchMemberById(String id);

	Member searchMemberByIdAndPasswd(String id, String passwd);

}