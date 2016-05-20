package com.springexample.demo04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimeService implements TimeService {

	SimpleDateFormat format;	
//	SimpleDateFormat format = 
//		new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");	
	public void setFormat(SimpleDateFormat format) {
		this.format = format;
	}
	
	public String getTime() {
		
		return format.format(new Date());
		
	}

}
