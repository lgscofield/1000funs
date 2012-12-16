/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳千方百味公司开发研制。
******************************************************************************/
package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.funs.order.appservice.OrderAppService;

/**
 * Servlet测试类
 *
 * @author 黄科林
 * @since jdk6.0
 * @version  2012-12-16 黄科林
 */
public class TestServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//初始化Spring的容器，得到一个ApplicationContext对象    
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());    
		//从context的得到一个bean,实例化对象
		//ITestTableDAOService dao=(ITestTableDAOService)context.getBean("ITestTableDAOService"); 
		//ITestTableDAOService2 orderAppService=(ITestTableDAOService2)context.getBean("ITestTableDAOService");
		OrderAppService orderAppService = (OrderAppService)context.getBean("OrderService");
		System.out.println("===========测试开始=========");
		orderAppService.doInsert();
		System.out.println("===========测试结束=========");
		
	}
}
