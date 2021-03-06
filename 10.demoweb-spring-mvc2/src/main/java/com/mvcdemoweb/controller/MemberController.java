package com.mvcdemoweb.controller;

import java.io.IOException;
import java.util.ArrayList;
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
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	private MemberDao dao;

	@Autowired
	@Qualifier(value = "oracleMemberDao")
	public void setMemberDao(MemberDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "member/list.action", method = RequestMethod.GET)
	public String list(Locale locale, Model model, HttpSession session, HttpServletRequest req) {

		// 로그인 체크 -> 로그인 되지 않은 사용자는 로그인 서블릿으로 이동
		req.getSession(true);
		if (session.getAttribute("loginuser") == null) {
			return "redirect:/account/login.action";
		}

		// 사용자 목록 데이터 조회
		ArrayList<Member> members = dao.getList();

		model.addAttribute("members", members);

		return "member/list";
	}

	@RequestMapping(value = "member/view.action", method = RequestMethod.GET)
	public String view(Locale locale, Model model, HttpServletRequest req, HttpServletResponse resp, String passwd,
			String memberId, HttpSession session, String memberid) throws IOException {


		// 1. 조회할 사용자 아이디 조사
		if (memberid == null || memberid.length() == 0) {
			// 아이디가 없으면 목록으로 이동 (redirect)
			return "redirect:/member/list.action";
		}
		// 2. 사용자 정보 조회
		// MemberDao dao = new MemberDao();
		Member member = dao.getMemberById(memberid);
		if (member == null) {
			// 조회 실패 하면 목록으로 이동 (redirect)
			return "redirect:/member/list.action";
		}
		// 3. 조회된 정보를 request에 저장 -> view(jsp)에서 사용하도록
		model.addAttribute("member", member);

		return "member/view";
	}

	@RequestMapping(value = "member/register.action", method = RequestMethod.GET)
	public String registerform(HttpSession session) {

		return "member/registerform";
	}

	@RequestMapping(value = "member/register.action", method = RequestMethod.POST)
	public String register(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Member member, boolean active) {

		/*Member member = new Member();
		member.setMemberId(memberId);
		passwd = Util.getHashedString(passwd, "SHA-256");
		member.setPasswd(passwd);
		member.setEmail(email);
		member.setUserType(userType);
		if (active) {
			member.setActive(true);
		} else {
			member.setActive(false);
		}*/
		
		member.setPasswd(Util.getHashedString(member.getPasswd(), "SHA-256")); 
		//MemberDao dao = new MemberDao();
		dao.insert(member);
		
		
		return "redirect:/member/list.action";
	}

}
