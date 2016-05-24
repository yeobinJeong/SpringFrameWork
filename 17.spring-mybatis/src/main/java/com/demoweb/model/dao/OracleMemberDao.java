package com.demoweb.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demoweb.model.dto.Member;

@Repository(value = "memberDao")
public class OracleMemberDao implements MemberDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertMember(Member member) {
		sqlSessionTemplate.insert(
			"com.demoweb.model.mapper.MemberMapper.insertMember",
			member);
	}

	public List<Member> selectMemberList() {
		
		List<Member> members = sqlSessionTemplate.selectList(
			"com.demoweb.model.mapper.MemberMapper.selectMembers2");
		
		return members;
	}

	public Member selectMemberById(String id) {
	Member member = sqlSessionTemplate.selectOne(
	"com.demoweb.model.mapper.MemberMapper.selectMemberById", id);	
	return member;
	}

	public Member selectMemberByIdAndPasswd(String id, String passwd) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("memberId", id);
	map.put("passwd", passwd);
	Member member = sqlSessionTemplate.selectOne(
	"com.demoweb.model.mapper.MemberMapper.selectMemberByIdAndPasswd", 
	map);
		
		return member;
		
	}

}











