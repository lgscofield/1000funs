package com.funs.shop.model;

import com.funs.core.base.model.BaseVO;

public class OrderViewFoodVO extends BaseVO {
	
	/**
	 * 食物名称
	 */
	private String food;
	
	/**
	 * 数量
	 */
	private int amount;

	public OrderViewFoodVO() {
	}

	public OrderViewFoodVO(String food, int amount) {
		this.food = food;
		this.amount = amount;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return food + " x" + amount;
	}
}
