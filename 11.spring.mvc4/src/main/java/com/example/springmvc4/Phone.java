package com.example.springmvc4;

import javax.validation.constraints.Pattern;

public class Phone {

	@Pattern(regexp ="[0-9]{2,3}[0-9]{3,4}[0-9]{4}")
	private String home;
	@Pattern(regexp ="[0-9]{2,3}[0-9]{3,4}[0-9]{4}")
	private String mobile;
	@Pattern(regexp ="[0-9]{2,3}[0-9]{3,4}[0-9]{4}")
	private String office;
	
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
}
