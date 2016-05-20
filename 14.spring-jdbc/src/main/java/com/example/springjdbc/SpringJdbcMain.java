package com.example.springjdbc;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.example.springjdbc.model.dto.Member;
import com.example.springjdbc.model.service.MemberService;

public class SpringJdbcMain {

	
	public static void main(String[] args){
		
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("app-context.xml");
		
		
		
		MemberService service = (MemberService)context.getBean("memberService");
		List<Member> members = service.getAllMembers();
		
		for(Member m : members){
			
			System.out.println(m.getMemberId());
		}
		
	}
}
