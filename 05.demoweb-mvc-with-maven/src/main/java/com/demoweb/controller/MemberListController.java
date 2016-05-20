package com.demoweb.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.model.dao.MemberDao;
import com.demoweb.model.dto.Member;

public class MemberListController implements Controller {

	private MemberDao dao;
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public ActionResult processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		ActionResult result = new ActionResult();
		
		//로그인 체크 -> 로그인 되지 않은 사용자는 로그인 서블릿으로 이동
		HttpSession session = request.getSession(true);
		if (session.getAttribute("loginuser") == null) {
			result.setUrl("loginform.action" + 
				"?returnurl=" + request.getRequestURI());
			result.setRedirect(true);
			return result;
		}
		
		//사용자 목록 데이터 조회
		//MemberDao dao = new MemberDao();
		ArrayList<Member> members = dao.getList();
		
		//view (.jsp)에서 사용하도록 request객체에 저장
		//->forward로 이동하기 때문에 request객체에 담으면 jsp에서 읽을 수 있습니다.
		request.setAttribute("members", members);
		
		result.setUrl("membermanager/list.jsp");
		result.setRedirect(false);
		
		return result;

	}

}
