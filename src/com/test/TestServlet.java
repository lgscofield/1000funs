/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
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
 * Servlet������
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
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
		
		//��ʼ��Spring���������õ�һ��ApplicationContext����    
		ApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());    
		//��context�ĵõ�һ��bean,ʵ��������
		//ITestTableDAOService dao=(ITestTableDAOService)context.getBean("ITestTableDAOService"); 
		//ITestTableDAOService2 orderAppService=(ITestTableDAOService2)context.getBean("ITestTableDAOService");
		OrderAppService orderAppService = (OrderAppService)context.getBean("OrderService");
		System.out.println("===========���Կ�ʼ=========");
		orderAppService.doInsert();
		System.out.println("===========���Խ���=========");
		
	}
}
