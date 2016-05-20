package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.demoweb.controller.ActionResult;
import com.demoweb.controller.Controller;
import com.demoweb.controller.ControllerFactory;
import com.demoweb.controller.HomeController;
import com.demoweb.controller.LoginController;
import com.demoweb.controller.LoginFormController;
import com.demoweb.controller.LogoutController;
import com.demoweb.controller.MemberListController;
import com.demoweb.controller.MemberRegisterController;
import com.demoweb.controller.MemberRegisterFormController;
import com.demoweb.controller.MemberViewController;

public class FrontController extends HttpServlet {
	
	//ControllerFactory factory;
	GenericXmlApplicationContext context;
	
	//서블릿이 생성되고 나서 초기화를 목적으로 호출되는 메서드
	// -> 일반적으로 서블릿 객체의 초기화 코드를 구현하는 장소로 사용
	@Override
	public void init(ServletConfig config) throws ServletException {
//		String path = config.getInitParameter("path");
//		path = config.getServletContext().getRealPath(path);
//		factory = new ControllerFactory(path);
		context = new GenericXmlApplicationContext("app-context.xml");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1. 요청 분석
		//http://............./aaa.action?id=xxx& -> aaa 추출
		String uri = req.getRequestURI();		
		int start = uri.lastIndexOf("/") + 1;
		int end = uri.lastIndexOf("?");
		String temp = "";
		if (end == -1) {
			temp = uri.substring(start);
		} else {
			temp = uri.substring(start, end);
		}
		String action = temp.substring(0, temp.lastIndexOf("."));
		
		//2. 처리기 선택
		//Controller controller = factory.getController(action);
		Controller controller = (Controller)context.getBean(action);
		
		//3. 처리기 호출
		ActionResult result = controller.processRequest(req, resp);
		
		//4. 결과에 따라서 View 선택
		//5. redirect or forward
		if (result.isRedirect()) {//redirect
			resp.sendRedirect(result.getUrl());
		} else {//forward
			RequestDispatcher disp = 
				req.getRequestDispatcher("/WEB-INF/views/" + result.getUrl());
			disp.forward(req, resp);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}





