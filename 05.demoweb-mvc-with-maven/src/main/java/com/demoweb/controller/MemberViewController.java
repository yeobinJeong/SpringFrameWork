package com.demoweb.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoweb.model.dao.MemberDao;
import com.demoweb.model.dto.Member;

public class MemberViewController implements Controller {

	private MemberDao dao;
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public ActionResult processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		ActionResult result = new ActionResult();
		
		//1. 조회할 사용자 아이디 조사
		if (request.getParameter("memberid") == null ||
			request.getParameter("memberid").length() == 0) {
			//아이디가 없으면 목록으로 이동 (redirect)
			result.setUrl("memberlist.action");
			result.setRedirect(true);
			return result;
		}
		String id = request.getParameter("memberid");
		//2. 사용자 정보 조회
		//MemberDao dao = new MemberDao();
		Member member = dao.getMemberById(id);
		if (member == null) {
			//조회 실패 하면 목록으로 이동 (redirect) 
			result.setUrl("memberlist.action");
			result.setRedirect(true);
			return result;
		}	
		//3. 조회된 정보를 request에 저장 -> view(jsp)에서 사용하도록 
		request.setAttribute("member", member);
		
		result.setUrl("membermanager/view.jsp");
		result.setRedirect(false);//forward로 이동
		return result;
	}

}
