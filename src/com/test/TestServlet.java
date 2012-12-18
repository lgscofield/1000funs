package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.comtop.top.cfg.client.util.JsonCommonUtil;
import com.funs.core.util.tools.DataGenerator;
import com.funs.user.appservice.UserAppService;
import com.funs.user.model.UserVO;

public class TestServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2399166345711874635L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());    
		
		UserAppService userAppService = (UserAppService)context.getBean("UserService");
		System.out.println("userAppService.doInsert(new User())");
		UserVO objUserVO = (UserVO)DataGenerator.get(UserVO.class,10);
		String strUserVO = JsonCommonUtil.objectToJson(objUserVO);
		userAppService.doInsert(strUserVO);
	}
}
