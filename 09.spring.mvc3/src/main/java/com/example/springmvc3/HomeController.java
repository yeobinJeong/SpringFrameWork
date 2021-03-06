package com.example.springmvc3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //@Component와 같이 IoC 컨테이너에 빈 등록하는 Annotation
public class HomeController {
	
	//요청과 그 요청을 처리할 메서드 연결하는 Annotation
	@RequestMapping(
		value = "/",				//요청 경로 http://localhost:8088/springmvc2/
		method = RequestMethod.GET) //요청 메서드
	public String home() {
		
		return "home"; //뷰이름 -> /WEB-INF/views/ + home + .jsp
	}
	
}
