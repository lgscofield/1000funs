/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* �����Ϊ����ǧ����ζ��˾�������ơ�
*****************************************************************************/
package com.funs.order.model;

/**
 * ����VO
 *
 * @author �ƿ���
 * @since jdk6.0
 * @version  2012-12-16 �ƿ���
 */
public class OrderVO {
	
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
	
	public String toString(){
		StringBuffer sb = new StringBuffer(128);
		sb.append("orderId="+orderId+"\n");
		sb.append("orderType="+orderType+"\n");
		sb.append("price="+price+"\n");
		return sb.toString();
	}
}
