/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.order.dao;

import java.util.List;

import com.funs.core.base.dao.BaseDAO;
import com.funs.order.model.OrderQueryCondition;
import com.funs.order.model.OrderVO;
import com.funs.order.model.OrderVOWithFood;

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

	/**
	 * 根据条件查询订单列表
	 * @param map 查询条件
	 * @return
	 */
	public List<OrderVOWithFood> queryOrdersWithFood(OrderQueryCondition params) {
		List<OrderVOWithFood> result = this.sqlSessionTemplate.selectList("com.funs.order.queryOrdersWithFood", params);
		return result;
	}
	
	/**
	 * 根据条件查询订单列表,分页方式
	 * @param map 查询条件
	 * @return
	 */
	public List<OrderVOWithFood> queryOrdersWithFoodByPage(OrderQueryCondition params) {
		List<OrderVOWithFood> result = this.sqlSessionTemplate.selectList("com.funs.order.queryOrdersWithFoodByPage", params);
		return result;
	}
	
	/**
	 * 根据条件查询订单列表的数量
	 * @param params
	 * @return
	 */
	public int queryOrdersCount(OrderQueryCondition params) {
		int count = this.sqlSessionTemplate.selectOne("com.funs.order.queryOrdersCount", params);
		return count;
	}
}
