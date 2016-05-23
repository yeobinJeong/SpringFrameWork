package com.demoweb.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demoweb.model.dto.Member;

@Repository(value = "memberDao2")
public class OracleMemberDao2 implements MemberDao {
	
//	@Autowired
//	@Qualifier("dataSource3")
//	private DataSource dataSource;
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

	@Autowired
	@Qualifier("namedJdbcTemplate")
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	public void insertMember(Member member) {
		String sql = "INSERT INTO member ("
				+ "memberid, passwd, email, usertype, active) "
				+ "VALUES (:memberId, :passwd, :email, :userType, :active)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("memberId", member.getMemberId(), Types.VARCHAR);
		params.addValue("passwd", member.getPasswd(), Types.VARCHAR);
		params.addValue("email", member.getEmail(), Types.VARCHAR);
		params.addValue("userType", member.getUserType(), Types.VARCHAR);
		params.addValue("active", member.isActive(), Types.BOOLEAN);
		
		jdbcTemplate.update(sql, params);
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("memberId", member.getMemberId());
//		params.put("passwd", member.getPasswd());
//		params.put("email", member.getEmail());
//		params.put("userType", member.getUserType());
//		params.put("active", member.isActive());
		
		
	}

	public List<Member> selectMemberList() {

		String sql = 
			"SELECT memberid, email, usertype, active, regdate " + 
			"FROM member";
		
		List<Member> members = jdbcTemplate.query(sql, new RowMapper<Member>() {
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
			"WHERE memberid = :id";
	
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		Member member = jdbcTemplate.queryForObject(sql, params, new RowMapper<Member>() {
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
			"WHERE memberid = :id AND passwd = :passwd";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		params.addValue("passwd", passwd);
		
		Member member = jdbcTemplate.queryForObject(sql, params, new RowMapper<Member>() {
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











