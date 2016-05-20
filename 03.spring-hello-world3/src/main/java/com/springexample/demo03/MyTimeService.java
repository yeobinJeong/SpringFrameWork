package com.springexample.demo03;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

public class MyTimeService implements TimeService {

	SimpleDateFormat format = 
		new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");	
	
	public String getTime() {
		
		return format.format(new Date());
		
	}

}
