package com.mvcdemoweb.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	//2개 이상의 경로를 배열로 묶어서 매핑 가능
	@RequestMapping(value = { "/", "home.action" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println("in home");
		return "index"; // /WEB-INF/views/ + index + .jsp
	}
	
}




