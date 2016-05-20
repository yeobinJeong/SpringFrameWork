package com.springexample.demo02;

import org.springframework.stereotype.Component;

@Component(value = "myMessageService")
public class MyMessageService implements MessageService {

	public String getMessage() {
		return "Hello, Spring IoC Container !!!";
	}

}
