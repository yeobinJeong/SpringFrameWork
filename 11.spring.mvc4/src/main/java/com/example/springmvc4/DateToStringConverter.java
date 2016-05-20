package com.example.springmvc4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateToStringConverter implements Converter<Date, String>{

	@Override
	public String convert(Date arg0) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			return df.format(arg0);
		}catch(Exception e){
			return null;
		}
		
	}
		
	

}