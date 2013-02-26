/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/
package com.funs.order.action;

import java.util.List;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.funs.core.base.action.BaseAction;
import com.funs.core.base.model.ResultVO;
import com.funs.core.springmvc.ApplicationContextInitor;
import com.funs.order.model.OrderVO;
import com.funs.order.service.OrderService;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2012-12-18 Xingling build
 */
@RemoteProxy
public class OrderAction extends BaseAction {
	
	final static Logger LOGGER = LoggerFactory.getLogger(OrderAction.class);
	
	static ApplicationContext context = null;
	
	static OrderService orderService = null;
	
	static{
		context = ApplicationContextInitor.getContext();
		orderService = (OrderService)context.getBean("OrderService");
	}
	
	/**
	 * 提交订单
	 * @param orderVO
	 * @return 提交是否成功
	 */
	public ResultVO submitOrder(OrderVO orderVO){
		try{
			orderService.submitOrder(orderVO);
		}catch(Exception e){
			LOGGER.error("submitOrder 出错："+e);
			return new ResultVO("提交订单时后台出现错误"+e);
		}
		return new ResultVO();
	}
	
	/**
	 * 根据用户id查询未处理订单
	 * @param userId
	 * @return 未处理的订单对象集合
	 */
	@RemoteMethod
	public List<OrderVO> queryUnEvaluateOrder(int userId){
		try{
			return orderService.queryUnEvaluateOrder(userId);
		}catch(Exception e){
			LOGGER.error("queryUnEvaluateOrder 出错："+e);
			return null;
		}
	}
	
}
