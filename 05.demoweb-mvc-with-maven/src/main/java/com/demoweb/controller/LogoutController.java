package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {

	public ActionResult processRequest(
		HttpServletRequest req, HttpServletResponse resp) {
		
		req.getSession().removeAttribute("loginuser");
		
		ActionResult result = new ActionResult();
		result.setUrl("home.action");	//어디로
		result.setRedirect(true);		//어떻게
		
		return result;
	
	}
	
}
