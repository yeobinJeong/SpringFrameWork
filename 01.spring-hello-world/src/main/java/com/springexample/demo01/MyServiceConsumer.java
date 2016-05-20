package com.springexample.demo01;

public class MyServiceConsumer implements ServiceConsumer {

	private MessageService messageService;	
	private TimeService timeService;
	
	public MyServiceConsumer() {}	
	public MyServiceConsumer(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public TimeService getTimeService() {
		return timeService;
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
