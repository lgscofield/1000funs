/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.order.appservice;

import com.funs.order.dao.OrderDAO;

/**
 * 
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public class OrderAppService {
	
	private OrderDAO orderDAO;

	public void doInsert() {
		this.orderDAO.doInsert();
	}
	
	public OrderDAO getOrderDAO() {   
		return orderDAO;  
	}
	
	//���setter��Ҫ��setter��ʽֻspring��ʵ��ע���ʱ����õķ���  
	public void setOrderDAO(OrderDAO testImpl) {   
		this.orderDAO = testImpl;  
	}
}
