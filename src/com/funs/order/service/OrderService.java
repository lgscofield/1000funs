/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.order.dao.OrderDAO;
import com.funs.order.model.OrderVO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class OrderService {

	final static Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

	private OrderDAO orderDAO;
	
	/**
	 * 提交订单
	 * @param orderVO
	 */
	public void submitOrder(OrderVO orderVO) {
		orderDAO.insertOrder(orderVO);
	}
	
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
}
