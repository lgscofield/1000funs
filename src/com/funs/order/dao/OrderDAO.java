/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳千方百味公司开发研制。
*****************************************************************************/
package com.funs.order.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.base.dao.BaseDAO;
import com.funs.order.model.OrderVO;

/**
 * 
 *
 * @author 黄科林
 * @since jdk6.0
 * @version  2012-12-16 黄科林
 */
public class OrderDAO extends BaseDAO{
	
	/**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class);
	
	public void doInsert()  {
		OrderVO objOrderVO = new OrderVO();
		int orderId=(int)Math.round(Math.random()*8999+1000);
		objOrderVO.setOrderId(orderId);
		objOrderVO.setOrderType("tc");
		objOrderVO.setPrice(15.00);
		LOGGER.info("========新增操作===================");
		System.out.println(this.sqlSessionTemplate);
		this.sqlSessionTemplate.insert("com.funs.order.doInsert", objOrderVO); 
		LOGGER.info("成功插入数据1：\n"+objOrderVO);
	}
}
