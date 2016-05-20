package com.springexample.demo04;

import java.util.Date;

public class MyMessageService implements MessageService {

	private Date data;
	public MyMessageService() {
		data = new Date();
	}
	
	public String getMessage() {
		return "Hello, Spring IoC Container (" + data + ")";
	}
	
	public void init() {
		System.out.println("init method is called");
	}	
	public void destroy() {
		System.out.println("destroy method is called");
	}

}






