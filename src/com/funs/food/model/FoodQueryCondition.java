package com.funs.food.model;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class FoodQueryCondition {

	private int shopId;
	private int type;
	
	public FoodQueryCondition() {
	}
	
	public FoodQueryCondition(int shopId, int type) {
		this.shopId = shopId;
		this.type = type;
	}

	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "FoodQueryCondition [shopId=" + shopId + ", type=" + type + "]";
	}
}
