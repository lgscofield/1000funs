/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳千方百味公司开发研制。
*****************************************************************************/
package com.funs.order.service;

import com.funs.order.dao.OrderDAO;

/**
 * 
 *
 * @author 黄科林
 * @since jdk6.0
 * @version  2012-12-16 黄科林
 */
public class OrderAppService {
	
	private OrderDAO orderDAO;

	public void doInsert() {
		this.orderDAO.doInsert();
	}
	
	public OrderDAO getOrderDAO() {   
		return orderDAO;  
	}
	
	//这个setter重要，setter方式只spring在实现注入的时候调用的方法  
	public void setOrderDAO(OrderDAO testImpl) {   
		this.orderDAO = testImpl;  
	}
}
