package com.example.springjdbc.model.dao;

import java.util.List;

import com.example.springjdbc.model.dto.Member;

public interface MemberDao {

	void insertMember(Member member);

	List<Member> selectMemberList();

	Member selectMemberById(String id);

	Member selectMemberByIdAndPasswd(String id, String passwd);

}