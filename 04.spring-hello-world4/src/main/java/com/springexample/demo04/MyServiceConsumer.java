package com.springexample.demo04;

public class MyServiceConsumer implements ServiceConsumer {

	private MessageService messageService;	
	private TimeService timeService;
	
	public void setMessageService(MessageService messageService) {
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
