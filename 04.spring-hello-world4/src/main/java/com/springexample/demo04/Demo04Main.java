package com.springexample.demo04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Demo04Main {

	public static void main(String[] args) {
				
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("app-context.xml");
		
		//app-context.xml 파일의 myMessageService 빈의 
		//scope 속성을 prototype or singleton으로 변경해서 테스트 
		MessageService service = 
			(MessageService)container.getBean("myMessageService");		
		System.out.println(service.getMessage());
		
		try { Thread.sleep(3000); } catch (Exception ex) {}
		
		service = 
			(MessageService)container.getBean("myMessageService");		
		System.out.println(service.getMessage());
		
		System.out.println("=========================");
		
		ServiceConsumer consumer = 
			(ServiceConsumer)container.getBean("myConsumer");
		consumer.doSomething();

	}

}
