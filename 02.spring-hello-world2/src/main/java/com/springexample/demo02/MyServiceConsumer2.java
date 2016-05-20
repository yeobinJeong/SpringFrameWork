package com.springexample.demo02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "myConsumer2")
public class MyServiceConsumer2 implements ServiceConsumer {

	//@Autowired
	//@Qualifier(value = "myMessageService")
	@Resource(name = "myMessageService")	
	private MessageService messageService;
	
	//@Autowired
	//@Qualifier(value = "myTimeService")
	@Resource(name = "myTimeService")
	private TimeService timeService;
	
	public void doSomething() {		
		//테스트 1. TimeService 호출
		String timeString = timeService.getTime();
		System.out.println(timeString);
		
		System.out.println(messageService.getMessage());
		
	}

}
