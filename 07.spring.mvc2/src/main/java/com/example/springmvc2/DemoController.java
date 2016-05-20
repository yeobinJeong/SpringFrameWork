package com.example.springmvc2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	@RequestMapping(
		value = "/param.action", method = RequestMethod.GET) 
	public String processRequest(
		HttpServletRequest req, 
		String data1,
		@RequestParam("data1") String datax) {		
		String data = req.getParameter("data1");
		System.out.println("data" +data);
		System.out.println("data1" + data1);
		System.out.println("datax" + datax);		
		return "result";
	}
	
	@RequestMapping(
		value = "/param.action", method = RequestMethod.POST) 
	public ModelAndView processRequest2(HttpServletRequest req,  
			Person person, Model model) {
		System.out.println(person.getName()+ person.getPhone()+ person.getEmail());
		
		
		req.setAttribute("person", person);
		
		model.addAttribute("person", person);
		
		ModelAndView mav = new ModelAndView();
		
	    mav.setViewName("result");
	    mav.addObject("person", person);//Request에 데이터 저장
	    
	    return mav;
	}
	
	
	
    
	
	
}



