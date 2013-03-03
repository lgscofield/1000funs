package com.funs.order.model;

import com.funs.core.base.model.BaseVO;

public class OrderItemVO extends BaseVO {
	
	public static final int ITEM_TYPE_FOOD = 0;
	public static final int ITEM_TYPE_PACKAGE = 1;

	private int id;

	private int orderId;

	/**
	 * 0 food , 1 package
	 */
	private int itemType;

	private int itemId;

	private int amount;

	private int deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}
