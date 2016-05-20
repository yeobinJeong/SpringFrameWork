package com.demoweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	ActionResult processRequest(
		HttpServletRequest req, HttpServletResponse resp);
	
}
