package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.user.service.UserService;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2013-01-07 Xingling build
 */
public class DWRTestAction extends ApplicationObjectSupport {
	
	static ApplicationContext context = null;
	
	static UserService userService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		userService = (UserService)context.getBean("UserService");
	}
	
	public String testSession(HttpServletRequest request,String param) {
		HttpSession session = request.getSession();
		String result =(String)session.getAttribute("testkey");
		session.setAttribute("testkey", param);
		return result;
	}
	
}
