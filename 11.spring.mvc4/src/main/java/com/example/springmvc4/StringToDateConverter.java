package com.example.springmvc4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date>{


	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try{
			return df.parse(arg0); 
		} catch(Exception e) {
			return null;
		}
		
		
	}

}
