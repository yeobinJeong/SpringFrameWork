package com.mvcdemoweb.model.dao;

import java.util.List;

import com.mvcdemoweb.model.dto.Member;

public interface MemberDao {

	void insert(com.mvcdemoweb.model.dto.Member member);

	List<Member> getList();

	Member getMemberById(String id);

	Member getMemberByIdAndPasswd(String id, String passwd);

}