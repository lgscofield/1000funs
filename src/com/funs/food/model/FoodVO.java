/******************************************************************************
 * Copyright (C) 2012 ShenZhen 1000funs Information Technology Co.,Ltd
 * All Rights Reserved.
 *****************************************************************************/

package com.funs.food.model;

import com.funs.core.base.model.BaseVO;
import com.funs.core.util.tools.DataGenerator;

/**
 * @author Xingling
 * @since JDK1.6
 * @history 2013-01-06 Xingling build
 */
public class FoodVO extends BaseVO{

	private int id;

	private String code;

	private String foodName;

	private String detail;

	private String image;

	private int shopId;

	private int groupId;

	private double originPrice;
	
	private double currentPrice;
	
	private int stock;
	
	private boolean droped;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}



	public int getShopId() {
		return shopId;
	}


	public void setShopId(int shopId) {
		this.shopId = shopId;
	}


	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}


	public double getOriginPrice() {
		return originPrice;
	}


	public void setOriginPrice(double originPrice) {
		this.originPrice = originPrice;
	}


	public double getCurrentPrice() {
		return currentPrice;
	}


	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public boolean isDroped() {
		return droped;
	}


	public void setDroped(boolean droped) {
		this.droped = droped;
	}


	public static void main(String[] args) {
		FoodVO food = (FoodVO)DataGenerator.get(FoodVO.class);
		System.out.println(food.toString());
	}

}
