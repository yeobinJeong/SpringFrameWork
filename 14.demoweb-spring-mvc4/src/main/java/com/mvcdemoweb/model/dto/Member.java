package com.mvcdemoweb.model.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Member implements Serializable {
	
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9]{8,15}", message = "아이디 형식 오류")
	private String memberId;
	@NotEmpty
	@Pattern(regexp = "[A-Za-z0-9]{8,15}", message = "열쇠글 형식 오류")
	private String passwd;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Pattern(regexp = "(user|admin){1}")
	private String userType;
	private boolean active;	
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
	
	

}
