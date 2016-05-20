package com.springexample.demo02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Demo02Main {

	public static void main(String[] args) {
		
		//1. 직접 객체를 생성하고 의존성을 관리하는 방식 
		//MyServiceConsumer consumer = new MyServiceConsumer();
		//consumer.doSomething();
		
		//2. Spring Container를 사용해서 객체의 수명과 의존성 관리
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("app-context.xml");		
		ServiceConsumer consumer = 
			//(ServiceConsumer)container.getBean("myConsumer");
			(ServiceConsumer)container.getBean("myConsumer2");
		
		consumer.doSomething();

	}

}
