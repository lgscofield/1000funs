/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.order.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.funs.core.base.dao.BaseDAO;
import com.funs.order.model.OrderVO;

/**
 * 
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public class OrderDAO extends BaseDAO{
	
	/**
     * ��־
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class);
	
	public void doInsert()  {
		OrderVO objOrderVO = new OrderVO();
		int orderId=(int)Math.round(Math.random()*8999+1000);
		objOrderVO.setOrderId(orderId);
		objOrderVO.setOrderType("tc");
		objOrderVO.setPrice(15.00);
		LOGGER.info("========�������===================");
		System.out.println(this.sqlSessionTemplate);
		this.sqlSessionTemplate.insert("com.funs.order.doInsert", objOrderVO); 
		LOGGER.info("�ɹ��������1��\n"+objOrderVO);
	}
}
