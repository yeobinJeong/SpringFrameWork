package com.example.springjdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Repository;

import com.example.springjdbc.model.dto.Member;

@Repository(value="memberDao")
public class OracleMemberDao implements MemberDao{

	@Autowired
	@Qualifier("dataSource3")
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void insertMember(Member member) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		try {
			conn = dataSource.getConnection();
			
			String sql =
				"INSERT INTO member (" + 
				"memberid, passwd, email, usertype, active) " + 
				"VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getUserType());
			pstmt.setBoolean(5, member.isActive());
			//4. execute
			pstmt.executeUpdate();
			//5. Process Result if Exist (in case select query)
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			//6. close
			if (pstmt != null) 
				try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) 
				try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	public List<Member> selectMemberList() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> members = new ArrayList<Member>();
		
		try {
			conn = dataSource.getConnection();
			String sql = 
				"SELECT memberid, email, usertype, active, regdate " + 
				"FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));				
				member.setUserType(rs.getString(3));
				member.setActive(rs.getBoolean(4));
				member.setRegDate(rs.getDate(5));
				members.add(member);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeConnection(conn);
			JdbcUtils.closeResultSet(rs);
		}
		return members;	
		
	}

	public Member selectMemberById(String id) {
		// 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"SELECT memberid, email, usertype, active, regdate " + 
				"FROM member WHERE memberid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));				
				member.setUserType(rs.getString(3));
				member.setActive(rs.getBoolean(4));
				member.setRegDate(rs.getDate(5));
				//members.add(member);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return member;	
	}

	public Member selectMemberByIdAndPasswd(String id, String passwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = 
				"SELECT memberid, email, usertype, active, regdate " + 
				"FROM member WHERE memberid = ? AND passwd = ? AND active = '1'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString(1));
				member.setEmail(rs.getString(2));				
				member.setUserType(rs.getString(3));
				member.setActive(rs.getBoolean(4));
				member.setRegDate(rs.getDate(5));
			}
		} catch (Exception ex) {
			member = null;
		} finally {
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return member;
		
	}

}
