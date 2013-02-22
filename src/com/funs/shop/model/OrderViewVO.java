package com.funs.shop.model;

import java.util.List;

import com.funs.core.base.model.BaseVO;

public class OrderViewVO extends BaseVO {
	
	/**
	 * 订单号
	 */
	private int id;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 */
	private String contact;
	
	/**手机*/
	private String phone;
	
	/**
	 * 总价格
	 */
	private double totalPrice;
	
	/**
	 * 食品总数
	 */
//	private int totalAmount;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 期望送达时间
	 */
	private String exceptTime;
	
	/**
	 * 食物列表
	 */
	private List<OrderViewFoodVO> foodList;
	
	/**
	 * 订单状态: 0:new 1:dealed 2:exception 3:evaluated
	 * TODO:: 字义到常量类中去
	 */
	private int orderStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalAmount() {
		return this.foodList.size();
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExceptTime() {
		return exceptTime;
	}

	public void setExceptTime(String exceptTime) {
		this.exceptTime = exceptTime;
	}

	public List<OrderViewFoodVO> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<OrderViewFoodVO> foodList) {
		this.foodList = foodList;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
}
