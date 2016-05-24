package com.demoweb.model.mapper;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class MemberTypeHandler implements TypeHandler {

	public Object getResult(ResultSet rs, String columnName) throws SQLException {

		
		System.out.println(columnName);
		
		if (columnName.toLowerCase().equals("u")) {			
			if (rs.getString(columnName).equals("user")) {
				return "일반사용자";
			} else {
				return "관리자";
			}
		} else if (columnName.toLowerCase().equals("aa")) {
			if (rs.getBoolean(columnName)) {
				return "활성사용자";
			} else {
				return "비활성사용자";
			}
		}
		return null;
	}

	public Object getResult(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getResult(CallableStatement arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setParameter(PreparedStatement arg0, int arg1, Object arg2, JdbcType arg3) throws SQLException {
		// TODO Auto-generated method stub
		
	}



}
