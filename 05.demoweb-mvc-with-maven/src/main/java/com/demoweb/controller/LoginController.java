package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.common.Util;
import com.demoweb.model.dao.MemberDao;
import com.demoweb.model.dto.Member;

public class LoginController implements Controller {

	private MemberDao dao;
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public ActionResult processRequest(
		HttpServletRequest req, HttpServletResponse resp) {
		
		//요청 데이터 읽기
		String id = req.getParameter("memberId");
		String passwd = req.getParameter("passwd");
		passwd = Util.getHashedString(passwd, "SHA-256");

		//요청 처리
		//MemberDao dao = new MemberDao();
		Member member = dao.getMemberByIdAndPasswd(id, passwd);
		
		ActionResult result = new ActionResult();
		if (member == null) {
			result.setUrl("loginform.action?loginid=" + id);
			result.setRedirect(true);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginuser", member);
			
			result.setUrl("home.action");
			result.setRedirect(true);
		}
		
		return result;
	}
	
}
