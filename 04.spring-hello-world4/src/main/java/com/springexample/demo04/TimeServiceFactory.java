package com.springexample.demo04;

public class TimeServiceFactory {
	
	public static TimeService newInstance() {
		
		return new MyTimeService();
		
	}

}
