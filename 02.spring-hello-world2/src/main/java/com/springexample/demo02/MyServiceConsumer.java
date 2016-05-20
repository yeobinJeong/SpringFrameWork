package com.springexample.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "myConsumer")
public class MyServiceConsumer implements ServiceConsumer {

	private MessageService messageService;	
	private TimeService timeService;
	
	public MyServiceConsumer() {}
	@Autowired //xml의 <constructor-arg에 해당하는 의미	
	public MyServiceConsumer(
		@Qualifier(value = "myMessageService") MessageService messageService) {
		this.messageService = messageService;
	}
	@Autowired //xml의 <property 에 해당하는 의미
	@Qualifier(value = "myTimeService")//대상의 이름을 지정할 때 사용
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
