/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.order.dao;

import java.util.List;

import com.funs.core.base.dao.BaseDAO;
import com.funs.order.model.OrderVO;

/**
 * @author Xingling
 * @since jdk6.0
 * @version 2012-12-16 Xingling build
 */
public class OrderDAO extends BaseDAO {

	/**
	 * 插入Order数据到数据库
	 * @param orderVO
	 */
	public void insertOrder(OrderVO orderVO) {
		this.sqlSessionTemplate.insert("com.funs.order.insertOrder", orderVO);
	}
	
	/**
	 * 根据用户id查询未处理订单
	 * @param userId
	 * @return 未处理的订单对象集合
	 */
	public List<OrderVO> queryUnEvaluateOrder(int userId){
		List<OrderVO> result =  this.sqlSessionTemplate.selectList("com.funs.order.queryUnEvaluateOrder", userId);
		return result;
	}
	
}
