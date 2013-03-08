/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.base.service.BaseService;
import com.funs.order.dao.OrderDAO;
import com.funs.order.model.OrderQueryCondition;
import com.funs.order.model.OrderVO;
import com.funs.order.model.OrderVOWithFood;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class OrderService extends BaseService {

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
	
	/**
	 * 根据用户id查询未处理订单
	 * @param userId
	 * @return 未处理的订单对象集合
	 */
	public List<OrderVO> queryUnEvaluateOrder(int userId){
		return orderDAO.queryUnEvaluateOrder(userId);
	}
	
	/**
	 * 根据条件查询订单列表
	 * @param map 查询条件
	 * @return
	 */
	public List<OrderVOWithFood> queryOrdersWithFood(OrderQueryCondition params) {
		return orderDAO.queryOrdersWithFood(params);
	}
	
	/**
	 * 根据条件查询订单列表,分页方式
	 * @param map 查询条件
	 * @return
	 */
	public List<OrderVOWithFood> queryOrdersWithFoodByPage(OrderQueryCondition params) {
		return orderDAO.queryOrdersWithFoodByPage(params);
	}
	
	/**
	 * 根据条件查询订单列表的数量
	 * @param params
	 * @return
	 */
	public int queryOrdersCount(OrderQueryCondition params) {
		return orderDAO.queryOrdersCount(params);
	}
}
