/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 * �����Ϊ����ǧ����ζ��˾�������ơ�
 *****************************************************************************/
package com.funs.order.model;

import com.comtop.top.cfg.client.util.JsonCommonUtil;
import com.funs.core.base.model.BaseVO;

/**
 * ����VO
 * 
 * @author �ƿ���
 * @since jdk6.0
 * @version 2012-12-16 �ƿ���
 */
public class OrderVO extends BaseVO {

	/**
	 * ������
	 */
	private int orderId;

	/**
	 * �������
	 */
	private String orderType;

	/**
	 * �۸�
	 */
	private double price;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static void main(String[] args) {
		OrderVO order = new OrderVO();
		order.setOrderId(1);
		order.setOrderType("type1");
		order.setPrice(2.2);
		System.out.println("toString:" + order.toString());
	}
}
