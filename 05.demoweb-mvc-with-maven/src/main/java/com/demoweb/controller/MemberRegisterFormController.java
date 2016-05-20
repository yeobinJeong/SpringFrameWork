package com.demoweb.controller;

import javax.servlet.http.*;

public class MemberRegisterFormController implements Controller {

	public ActionResult processRequest(HttpServletRequest req,
			HttpServletResponse resp) {
		
		ActionResult result = new ActionResult();
		result.setUrl("membermanager/registerform.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
