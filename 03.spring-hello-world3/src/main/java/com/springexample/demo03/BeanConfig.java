package com.springexample.demo03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //app-context.xml 의 Bean 등록 및 의존성 관리 기능 수행
public class BeanConfig {
	
	@Bean //<bean id='myConsumer' class='...MyServiceConsumer' />
	public MyServiceConsumer myConsumer() {
		MyMessageService messageService = myMessageService();
		MyServiceConsumer consumer = 
			new MyServiceConsumer(messageService);
		consumer.setTimeService(myTimeService());
		return consumer;
	}	
	@Bean public MyMessageService myMessageService() {
		return new MyMessageService();
	}	
	@Bean public MyTimeService myTimeService() {
		return new MyTimeService();
	}
	
	

}
