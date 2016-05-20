package com.demoweb.controller;

import javax.servlet.http.*;

import com.demoweb.common.Util;
import com.demoweb.model.dao.*;
import com.demoweb.model.dto.*;

public class MemberRegisterController  implements Controller  {

	private MemberDao dao;
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public ActionResult processRequest(
		HttpServletRequest req, HttpServletResponse resp)  {
		
		Member member = new Member();
		member.setMemberId(req.getParameter("memberId"));
		String passwd = Util.getHashedString(req.getParameter("passwd"), "SHA-1");
		member.setPasswd(passwd);
		member.setEmail(req.getParameter("email"));
		member.setUserType(req.getParameter("userType"));
		if (req.getParameter("active") != null && req.getParameter("active").equals("y")) {
			member.setActive(true);
		} else {
			member.setActive(false);
		}
		
		//MemberDao dao = new MemberDao();
		dao.insert(member);
		
		ActionResult result = new ActionResult();
		result.setUrl("memberlist.action");
		result.setRedirect(true);
		
		return result;
	
	}
	
}
