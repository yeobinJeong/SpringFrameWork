package com.springexample.demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class MyServiceConsumer implements ServiceConsumer {

	private MessageService messageService;	
	private TimeService timeService;
	
	public MyServiceConsumer() {}	
	public MyServiceConsumer(MessageService messageService) {
		this.messageService = messageService;
	}
	public void setTimeService(TimeService timeService) {
		this.timeService = timeService;
	}

	public void doSomething() {		
		//테스트 1. TimeService 호출
		String timeString = timeService.getTime();
		System.out.println(timeString);
		
		System.out.println(messageService.getMessage());
		
	}

}
