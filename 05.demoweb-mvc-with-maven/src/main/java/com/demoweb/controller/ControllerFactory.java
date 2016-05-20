package com.demoweb.controller;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ControllerFactory {
	
	private Map<String, Controller> controllers;
	
	public ControllerFactory(String mappingFilePath) {
		controllers = new HashMap<String, Controller>();
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(mappingFilePath);
			props.load(fis);
			
			Set<Object> keys = props.keySet();
			for (Object key : keys) {
				String keyName = key.toString();
				try {
					String typeName = props.getProperty(keyName);
					Class claz = Class.forName(typeName);   
					Controller controller = (Controller)claz.newInstance();
					controllers.put(keyName, controller);
				} catch (Exception ex) {}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { fis.close(); } catch (Exception ex) {}
		}
	}
	
	public Controller getController(String action) {
		
		Controller controller = null;

//		if (action.equals("home")) {
//			controller = new HomeController();			
//		} else if (action.equals("loginform")) {
//			controller = new LoginFormController();			
//		} else if (action.equals("login")) {
//			controller = new LoginController();
//		} else if (action.equals("logout")) {
//			controller = new LogoutController();
//		} else if (action.equals("memberlist")) {
//			controller = new MemberListController();
//		} else if (action.equals("memberregisterform")) {
//			controller = new MemberRegisterFormController();
//		} else if (action.equals("memberregister")) {
//			controller = new MemberRegisterController();
//		} else if (action.equals("memberview")) {
//			controller = new MemberViewController();
//		} else { 
//			controller = new HomeController();
//		}
		
		controller = controllers.get(action);
		
		return controller;
	}

}
