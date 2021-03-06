package com.mvcdemoweb.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcdemoweb.common.Util;
import com.mvcdemoweb.model.dao.MemberDao;
import com.mvcdemoweb.model.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	
	private MemberDao dao;
	
	@Autowired
	@Qualifier(value ="oracleMemberDao")
	public void setMemberDao(MemberDao dao){
		this.dao = dao;
	}
	
	
	@RequestMapping(value = "account/login.action", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "account/loginform";
	}
	@RequestMapping(value = "account/login.action", method = RequestMethod.POST)
	public String index(Locale locale, Model model, HttpServletRequest req, HttpServletResponse resp,
			String passwd, String memberId, HttpSession session) throws IOException {
		//요청 데이터 읽기
				passwd = Util.getHashedString(passwd, "SHA-256");
				Member member = dao.getMemberByIdAndPasswd(memberId, passwd);
				
				if (member == null) {
					//실패 했을시에는 forward 방식으로 보냄
					System.out.println("실패");
					return "account/loginform";
					
				} else {
					//성공했을 시에는 redirect
					session.setAttribute("loginuser", member);
					return "redirect:/home.action";
				}
	}
	
	@RequestMapping(value = "account/logout.action", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginuser");
		return "redirect:/home.action";
	}
	
	
}
