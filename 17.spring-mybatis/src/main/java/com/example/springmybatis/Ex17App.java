package com.example.springmybatis;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.demoweb.common.Util;
import com.demoweb.model.dto.Member;
import com.demoweb.model.service.MemberService;

public class Ex17App {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext iocContainer = 
				new GenericXmlApplicationContext("app-context.xml");//경로는 package경로를 의미
			
			MemberService memberService = (MemberService)iocContainer.getBean("memberService");
			
			Member member = new Member();
			member.setMemberId( String.format("%010d", (int)(Math.random() * 10000)) );//0001,0756
			member.setEmail(member.getMemberId() + "@example.com");
			member.setPasswd(Util.getHashedString("test", "SHA-256"));
			member.setUserType("user");
			member.setActive(true);
			
			memberService.registerMember(member);
			
			System.out.println("신규 멤버를 등록했습니다.");
			System.out.println("=================================");
			
			List<Member> members = memberService.getAllMembers();
			for (Member m : members) {
				System.out.println(m.toString());
			}
			
			System.out.println("=================================");
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Input ID : ");
			String id = scanner.nextLine();
			
			Member member2 = memberService.searchMemberById(id);
			System.out.println(member2.toString());
			
			System.out.println("=================================");
			
			System.out.print("Input ID : ");
			id = scanner.nextLine();
			System.out.print("Input Passwd : ");
			String passwd = scanner.nextLine();
			passwd = Util.getHashedString(passwd, "SHA-256");
			
			Member member3 = memberService.searchMemberByIdAndPasswd(id, passwd);
			System.out.println(member3.toString());
			
			scanner.close();

	}

}
