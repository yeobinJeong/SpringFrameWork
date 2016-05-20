package com.demoweb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionHelper {
	
	public static Connection getConnection(String dbname) {
		
		if (dbname.toLowerCase().equals("oracle")) {
			try {
				//1. 직접 연결 객체 생성
//				Class.forName("oracle.jdbc.OracleDriver");				
//				Connection conn = 
//					DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "demoweb", "oracle");
				
				//2. Tomcat Container 지원 DataSource 사용
				//   (Database Connection Pool 사용)				
				Context initContext = new InitialContext();
				Context context = 
					(Context)initContext.lookup("java:/comp/env");
				DataSource source = 
					(DataSource)context.lookup("jdbc/demoweb");
				Connection conn = source.getConnection();
				
				return conn;
			} catch (Exception ex) {
				return null;
			}
		} else if (dbname.toLowerCase().equals("mysql")) {
			try {
				//1.
				//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = 
					DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", "devadmin", "mysql");
				
				//2.
				/*
				Context initContext = new InitialContext();
				Context context = 
					(Context)initContext.lookup("java:/comp/env");
				DataSource source = 
					(DataSource)context.lookup("mysql/demoweb");
				Connection conn = source.getConnection();
				*/
				return conn;
			} catch (Exception ex) {
				return null;
			}
		} else {
			return null;
		}
		
	}

}
