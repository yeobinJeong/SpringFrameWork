package com.demoweb.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.demoweb.model.dto.Member;

public class OracleMemberDao3 extends JdbcDaoSupport implements MemberDao {
	
	public void insertMember(Member member) {
		String sql = "INSERT INTO member ("
				+ "memberid, passwd, email, usertype, active) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		getJdbcTemplate().update(
			sql, 
			member.getMemberId(), member.getPasswd(),
			member.getEmail(), member.getUserType(),
			member.isActive());
	}

	public List<Member> selectMemberList() {

		String sql = 
			"SELECT memberid, email, usertype, active, regdate " + 
			"FROM member";
		
		//List<Member> members = jdbcTemplate.queryForList(sql, Member.class);
		
		List<Member> members = getJdbcTemplate().query(sql, new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int index) throws SQLException {
				
				Member member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setActive(rs.getBoolean(4));
				member.setRegDate(rs.getDate(5));
				
				return member;
			}			
		});
		
		return members;
	}

	public Member selectMemberById(String id) {
		
		String sql = 
			"SELECT memberid, email, usertype, active, regdate " + 
			"FROM member " +
			"WHERE memberid = ?";
	
		Member member = getJdbcTemplate().queryForObject(sql, new Object[] { id }, new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int index) throws SQLException {
				
				Member member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setActive(rs.getBoolean(4));
				member.setRegDate(rs.getDate(5));
				
				return member;
			}			
		});
		
		return member;
	}

	public Member selectMemberByIdAndPasswd(String id, String passwd) {
		
		String sql = 
			"SELECT memberid, email, usertype, active, regdate " + 
			"FROM member " +
			"WHERE memberid = ? AND passwd = ?";
			
		Member member = getJdbcTemplate().queryForObject(sql, new Object[] { id, passwd }, new RowMapper<Member>() {
			public Member mapRow(ResultSet rs, int index) throws SQLException {
				
				Member member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));
				member.setUserType(rs.getString(3));
				member.setActive(rs.getBoolean(4));
				member.setRegDate(rs.getDate(5));
				
				return member;
			}			
		});
		
		return member;
		
	}

}











