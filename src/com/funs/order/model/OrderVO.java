/******************************************************************************
* Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
* All Rights Reserved.
* 本软件为深圳千方百味公司开发研制。
*****************************************************************************/
package com.funs.order.model;

/**
 * 订单VO
 *
 * @author 黄科林
 * @since jdk6.0
 * @version  2012-12-16 黄科林
 */
public class OrderVO {
	
	/**
     * 订单号
     */
	private int orderId;
	
	/**
     * 订单类别
     */
	private String orderType;
	
	/**
     * 价格
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
