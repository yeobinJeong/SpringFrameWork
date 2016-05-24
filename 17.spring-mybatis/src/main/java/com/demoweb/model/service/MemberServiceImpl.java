package com.demoweb.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demoweb.model.dao.MemberDao;
import com.demoweb.model.dto.Member;

@Service(value = "memberService")
public class MemberServiceImpl implements MemberService {	
	
	@Autowired
	@Qualifier("memberDao")
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		System.out.println("MemberServiceImpl 객체가 생성되었습니다 1.");
	}
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
		System.out.println("MemberServiceImpl 객체가 생성되었습니다 2.");
	}	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void registerMember(Member member) {
		memberDao.insertMember(member);
	}
	public List<Member> getAllMembers() {
		return memberDao.selectMemberList();
	}
	public Member searchMemberById(String id) {
		return memberDao.selectMemberById(id);
	}
	public Member searchMemberByIdAndPasswd(String id, String passwd) {
		return memberDao.selectMemberByIdAndPasswd(id, passwd);
	}
	
	/////////////////////////
	
	public void init() {
		System.out.println("init method is called");
	}
	
	public void destroy() {
		System.out.println("destroy method is called");
	}
	
	
}













