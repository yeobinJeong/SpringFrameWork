package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormController implements Controller {

	public ActionResult processRequest(
		HttpServletRequest req, HttpServletResponse resp) {
		
		//요청 데이터 읽기
		//요청 처리
		
		ActionResult result = new ActionResult();
		result.setUrl("loginform.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
