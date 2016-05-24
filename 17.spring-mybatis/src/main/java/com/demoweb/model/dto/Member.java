package com.demoweb.model.dto;

import java.sql.Date;

public class Member {

	private String memberId;
	private String passwd;
	private String email;
	private String userType;
	private boolean active;
	private String activeString;
	private Date regDate;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return String.format("[%s][%s][%s][%b][%s][%s]",
			memberId, email, userType, active, activeString, regDate.toString());
	
	}
	public String getActiveString() {
		return activeString;
	}
	public void setActiveString(String activeString) {
		this.activeString = activeString;
	}
	
}
